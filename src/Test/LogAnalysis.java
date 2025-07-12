package Test;

import java.util.*;

class LogAnalysis {
    //int n, List<List<Integer>> log_data, List<Integer> query, int X
    public static void main(String[] args) {
        int n = 6;
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(4);l2.add(3);
        List<Integer> l3 = new ArrayList<>();
        l3.add(2);l3.add(6);
        List<Integer> l4 = new ArrayList<>();
        l4.add(6);l4.add(3);
        List<List<Integer>> l5 = new ArrayList<>();
        l5.add(l1);l5.add(l2);l5.add(l3);l5.add(l4);

        int X = 1;

        List<Integer> queries = new ArrayList<>();
        queries.add(1);
        queries.add(2);
        queries.add(3);
        queries.add(4);
        queries.add(5);
        queries.add(6);

       List<Integer> res1 = countServers(n, l5, X, queries);
        int[] queriesArray = {1, 2, 3, 4, 5, 6};
        int[][] logs = {
                {3, 2},
                {4, 3},
                {2, 6},
                {6, 3}
        };
        int[] res = countServers1(n, logs, X, queriesArray);

    }

    public static List<Integer> countServers(int n, List<List<Integer>> log_data, int X, List<Integer> query)
    {
        int querLength = query.size();
        int[][] queryAr = new int[querLength][0];
        for (int i = 0; i < querLength; ++i) {
            queryAr[i] = new int[] {query.get(i), i};
        }

        log_data.sort(Comparator.comparingInt(a -> a.get(1)));
        Arrays.sort(queryAr, Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> servMap = new HashMap<>();
        int[] result = new int[querLength];
        List<Integer> ans = new ArrayList<>();

        int j = 0, k = 0;

        for (int[] p : queryAr) {
            int r = p[0];
            int i = p[1];
            int l = r - X;
            while (k < log_data.size() && log_data.get(k).get(1) <= r)
            {
                servMap.put(log_data.get(k).get(0), servMap.getOrDefault(log_data.get(k).get(0), 0) + 1);
                k++;
            }
            while (j < log_data.size() && log_data.get(j).get(1) < l) {
                int count = servMap.get(log_data.get(j).get(0));
                if (count == 1) {
                    servMap.remove(log_data.get(j).get(0));
                } else {
                    servMap.put(log_data.get(j).get(0), count - 1);
                }
                j++;
            }
            result[i] = n - servMap.size();
        }

        for(int i = 0; i < querLength; ++i)
        {
            ans.add(result[i]);
        }
        return ans;
    }

    public static int[] countServers1(int n, int[][] logData, int x, int[] queries) {

        Arrays.sort(logData, Comparator.comparingInt(a -> a[1]));
        int queryLength = queries.length;
        int[][] queryArr = new int[queryLength][0];
        for (int i = 0; i < queryLength; ++i) {
            queryArr[i] = new int[] {queries[i], i};
        }
        Arrays.sort(queryArr, Comparator.comparingInt(a -> a[0]));
        Map<Integer, Integer> servMap = new HashMap<>();
        int[] result = new int[queryLength];
        int j = 0, k = 0;
        for (int[] q : queryArr) {
            int r = q[0], i = q[1];
            int l = r - x;
            while (k < logData.length && logData[k][1] <= r) {
                servMap.merge(logData[k++][0], 1, Integer::sum);
            }
            while (j < logData.length && logData[j][1] < l) {
                if (servMap.merge(logData[j][0], -1, Integer::sum) == 0) {
                    servMap.remove(logData[j][0]);
                }
                j++;
            }
            result[i] = n - servMap.size();
        }
        return result;
    }


}

