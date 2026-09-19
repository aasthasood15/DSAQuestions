package org.learn.dynamic.programing;

public class UnboundedKnapsack {

    public void unboundedKnapsack() {
        int[] wt = {1, 2, 3, 5};

        int[] price = {1, 4, 7, 10};
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
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }
    }
}
