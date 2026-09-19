package org.learn.dynamic.programing;

import java.util.Arrays;

public class RodCutting {

    public void rodCutting() {
        int rodLength = 5;
        int[] arr = {1, 2, 3, 4};
        int[] price = {1, 5, 8, 9};
        int[] dp = new int[rodLength + 1];
        Arrays.fill(dp, -1);
        System.out.print(rodCutting(rodLength, dp, arr, price));
    }

    public static int rodCutting(int len, int[] dp, int[] arr, int[] price) {
        if (len == 0)
            return dp[0] = 0;

        if (dp[len] != -1) {
            return dp[len];
        }
        int ans = 0;

        for (int i = 1; i <= arr.length; i++) {

            if (len - i >= 0) {
                ans = Math.max(ans, price[i - 1] + rodCutting((len - i), dp, arr, price));
                dp[len] = ans;
            }
        }
        return ans;
    }
}//Time Complexity O(N × M)
