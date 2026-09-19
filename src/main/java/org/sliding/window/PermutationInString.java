package org.sliding.window;

public class PermutationInString {
    public void permutationInString() {
        String s1 = "ab";
        String s2 = "eidbafg";
        boolean ans = false;
        int n = s1.length();
        int m = s2.length();
        if (m < n)
            ans = false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        if (isMatched(map1, map2)) {
            ans = true;
        }
        for (int i = 1; i < m - n + 1; i++) {
            map2[s2.charAt(i - 1) - 'a']--;

            map2[s2.charAt(i + n - 1) - 'a']++;
            if (isMatched(map1, map2)) {
                ans = true;
            }
        }
        System.out.println(ans);
    }

    public static boolean isMatched(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }

        }

        return true;
    }
}
