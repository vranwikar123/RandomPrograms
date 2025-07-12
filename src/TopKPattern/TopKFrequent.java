package TopKPattern;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 12, 11, 12, 11};
        int k = 2;
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<Map.Entry<Integer, Integer>>(
                        (e1, e2) -> e1.getValue() - e2.getValue());


        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // create a list of top k numbers
        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }

        Integer[] numbers = topNumbers.stream().toArray(Integer[]::new);
        System.out.println(topNumbers);
    }
}
