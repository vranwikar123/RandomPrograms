package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxPairChain {

    public static void main(String[] args) {
        int[][] example1 = {{1,2}, {3,4}, {2,3}};
        int maxLength = findMaxChainPairCount(example1);
        System.out.println(maxLength);
    }


    private static int findMaxChainPairCount(int[][] example1) {
        int result = 0;
        Arrays.sort(example1, Comparator.comparingInt(a -> a[1]));
        int chainEnd = Integer.MIN_VALUE;
        for(int[] pair: example1) {
            if(pair[0] > chainEnd) {
                chainEnd = pair[1];
                result++;
            }
        }

        return result;
    }

}
