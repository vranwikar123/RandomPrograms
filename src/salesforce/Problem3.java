package salesforce;

public class Problem3 {

        public static int minimumWeeklyInput(int[] costs, int weeks) {
            int n = costs.length;

            // Initialize the DP table where dp[i][j] represents the minimum sum of weekly inputs for i campaigns in j weeks
            int[][] dp = new int[n + 1][weeks + 1];

            // Initialize the dp table with a large value (infinity) except dp[0][0] = 0
            for (int[] row : dp) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = 0;

            // Compute the DP table
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= weeks; j++) {
                    int maxCost = 0;
                    for (int k = i; k >= 1; k--) {
                        maxCost = Math.max(maxCost, costs[k - 1]);
                        dp[i][j] = Math.min(dp[i][j], dp[k - 1][j - 1] + maxCost);
                    }
                }
            }

            // The final answer is the minimum sum of weekly inputs for organizing all n campaigns into 'weeks' weeks
            return dp[n][weeks];
        }

        public static void main(String[] args) {
            int[] costs = {1000, 500, 2000, 3000, 800};
            int weeks = 3;
            System.out.println(minimumWeeklyInput(costs, weeks));  // Output: 4500
        }
    }

