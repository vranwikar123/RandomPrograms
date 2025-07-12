package ArrayHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] inp = {
                        {1,3},
                        {2,6},
                        {8,10},
                        {15,18}
                    };
        int[][] op = mergeIntervals(inp);
    }

    private static int[][] mergeIntervals(int[][] inp) {

        Arrays.sort(inp, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();

        for(int[] interval: inp)
        {
            if(res.isEmpty() || res.getLast()[1] < interval[0])
            {
                res.add(interval);
            }
            else
            {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
