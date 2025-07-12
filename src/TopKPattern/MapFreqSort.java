package TopKPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MapFreqSort {
    public static void main(String[] args) {
        int[] inp = {1, 2, 1, 2, 2, 4, 4, 5};
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int in: inp)
            numFrequencyMap.put(in, numFrequencyMap.getOrDefault(in, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<Map.Entry<Integer, Integer>>(
                        (e1, e2) -> e2.getValue() - e1.getValue()
                );


        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            maxHeap.add(entry);
        }

        // create a list of top k numbers
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int freq = numFrequencyMap.get(maxHeap.peek().getKey());
            Integer in = maxHeap.poll().getKey();
            for(int i = 0; i < freq; i++) {
                sb.append(in);
            }
        }

        System.out.println(sb.toString());
    }
}
