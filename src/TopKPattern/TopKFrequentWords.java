package TopKPattern;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> {
                    if(e1.getValue() == e2.getValue())
                    {
                        return e2.getKey().compareTo(e2.getKey());
                    }
                    else
                        return e2.getValue() - e1.getValue();
                });

        for(String str : words)
        {
            map.put(str, map.getOrDefault(str, 0) + 1);

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        for(int i=0;i<k;i++)
        {
            res.add(pq.poll().getKey());
        }

        Collections.sort(res);
        System.out.println(res);
    }
}
