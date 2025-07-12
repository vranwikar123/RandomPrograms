package SlidingWindow;

import java.util.Stack;

/**
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
 *
 * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
 *
 * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 */
public class StockProfit {
    public static void main(String[] args) {
        int[] prices = {10,1,5,6,7,1};
        int profit = getMaxProfit(prices);
        System.out.println(profit);
    }

    private static int getMaxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        //Stack stack = new Stack
        while(right < prices.length)
        {
            if(prices[left] < prices[right])
            {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }
            else
            {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
