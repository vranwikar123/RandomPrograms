package TopKPattern;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestNums {
    public static void main(String[] args) {
        int[] inp = {3, 1, 5, 12, 2, 11};
        int k = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int i = 0; i < k; i++)
            minHeap.add(inp[i]);

        // go through the remaining numbers of the array, if the number from the array is
        // bigger than the top (smallest) number of the min-heap, remove the top number from
        // heap and add the number from array
        for (int i = k; i < inp.length; i++) {
            if (inp[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(inp[i]);
            }
        }
        System.out.println(minHeap);
    }
}
