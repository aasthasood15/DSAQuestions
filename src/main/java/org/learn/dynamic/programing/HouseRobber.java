package org.learn.dynamic.programing;

public class HouseRobber {
    public void houseRobber() {
        int[] a = {2, 7, 3, 1, 4};

        int[] dp = new int[a.length];
        if (a.length < 2) {
            dp[a.length - 1] = a[0];
        } else {
            dp[0] = a[0];
            dp[1] = Math.max(a[0], a[1]);
            for (int i = 2; i < a.length; i++) {
                dp[i] = Math.max(dp[i - 1], a[i] + dp[i - 2]);
            }
        }
        System.out.print(dp[a.length - 1]);
    }//O(n) Space Complexity = O(n)
}
