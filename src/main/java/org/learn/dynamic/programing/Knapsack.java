package org.learn.dynamic.programing;

public class Knapsack {
    public static void knapsack() {
        int[] wt = {3, 4, 6, 5};

        int[] price = {2, 3, 1, 4};
        int maxWt = 8;
        int[][] dp = new int[5][9];

        for (int i = 0; i <= wt.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= maxWt; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= wt.length; i++) {

            for (int j = 1; j <= maxWt; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(price[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }

//        Time = n × W × O(1)
//                = O(n × W)
    }
}
