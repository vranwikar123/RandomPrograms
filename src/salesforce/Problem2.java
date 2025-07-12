package salesforce;

import java.util.Arrays;

public class Problem2 {

    public static void main(String[] args) {

        int[] inp = {1000, 500, 2000, 8000, 1500};
        int k = 5;
        System.out.println(" Res "+ minimumWeeklyInput(inp, k));
    }

    public static int minimumWeeklyInput(int[] costs, int weeks) {
        int n = costs.length;
        // Initialize the DP table with infinity
        int[][] dp = new int[n + 1][weeks + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Base case: one week
        for (int i = 0; i <= n-1; i++) {
            dp[i][1] = Arrays.stream(costs, 0, i).max().getAsInt();
        }

        // Fill the DP table
        for (int j = 1; j <= weeks-1; j++) {
            for (int i = 0; i <= n-1; i++) {
                int maxCost = 0;
                for (int k = i - 1; k >= 0; k--) {
                    maxCost = Math.max(maxCost, costs[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + maxCost);
                }
            }
        }

        // The answer is the minimum sum of weekly inputs for all campaigns over the given weeks
        return dp[n][weeks];
    }
}

