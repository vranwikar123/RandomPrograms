package TopKPattern;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        String st = "Programming";
        Map<Character, Integer> numFrequencyMap = new HashMap<>();
        for (Character ch : st.toCharArray())
            numFrequencyMap.put(ch, numFrequencyMap.getOrDefault(ch, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<Map.Entry<Character, Integer>>(
                        (e1, e2) -> e2.getValue() - e1.getValue());


        for (Map.Entry<Character, Integer> entry : numFrequencyMap.entrySet()) {
            maxHeap.add(entry);
        }

        // create a list of top k numbers
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int freq = numFrequencyMap.get(maxHeap.peek().getKey());
            Character ch = maxHeap.poll().getKey();
            for(int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }
}
