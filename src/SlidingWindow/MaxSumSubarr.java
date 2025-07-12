package SlidingWindow;

/**
 * Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
 *
 * Example 1:
 *
 * Input: arr = [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
public class MaxSumSubarr {

    public static void main(String[] args) {
        MaxSumSubarr sol = new MaxSumSubarr();
        System.out.println("Maximum sum of a subarray of size K: "
                + sol.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + sol.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }

    private int findMaxSumSubArray(int k, int[] inp)
    {
        int maxSum = 0;
        int windowSum = 0;

        for(int i = 0; i <= inp.length - k; i++)
        {
            windowSum = 0;
            for(int j = i; j < i + k;j++)
            {
                windowSum += inp[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
