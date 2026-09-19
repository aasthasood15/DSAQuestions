package org.learn.dynamic.programing;

public class EditDistance {
    public void editDistance() {
        String s1 = "abcdef";
        String s2 = "azcde";
        int[][] dp = new int[s2.length() + 1][s1.length() + 1];

        for (int i = 0; i < s2.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < s1.length() + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < s2.length() + 1; i++) {
            for (int j = 1; j < s1.length() + 1; j++) {
                if (s2.charAt(i - 1) != s1.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    //min of diagonal, back ,above plus one
                } else {
                    dp[i][j] = dp[i - 1][j - 1];//diagonal
                }
            }

        }
        System.out.println(dp[5][6]);
    }// Time Complexity	O(m × n) Space Complexity	O(m × n)
}
