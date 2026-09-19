package org.learn.dynamic.programing;

public class LongestCommonSubSequence {

    public static void longestCommonSubSequence() {
        String str1 = "abcdaf";
        String str2 = "acbcf";
        int[][] dp = new int[str2.length() + 1][str1.length() + 1];

        for (int i = 0; i <= str2.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= str1.length() ; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;// diagonal+1
                } else {
                   dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);// max between back or above
                }
            }
        }
    }
}
