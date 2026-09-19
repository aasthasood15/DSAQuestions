package org.learn.dynamic.programing;

import java.util.Arrays;

public class CoinChange {

    public void coinProblem() {
        int[] arr = {7, 5, 1};
        int target = 18;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
    }

    public static int coinChange(int n, int[] arr, int[] dp) {

        int ans = Integer.MAX_VALUE;

        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int subAns;
            if (n - arr[i] >= 0) {
                if (dp[n - arr[i]] != -1) {
                    subAns = dp[n - arr[i]];
                } else {
                    subAns = coinChange(n - arr[i], arr, dp);
                }
                if (subAns + 1 < ans && subAns != Integer.MAX_VALUE) {
                    ans = subAns + 1;
                }
            }


        }

        return dp[n] = ans;
    }
//O(T × M) T-> number of states, M-> number of coin denominations
}
