package org.sliding.window;

public class MinWindowSubString {
    public void minimumWindowSubstring() {

        String s = "aebdecbcba";
        String t = "abcc";
        int minLen = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;
        int minStart = 0;
        int[] mapT = new int[256];
        int[] mapS = new int[256];

        for (int i = 0; i < t.length(); i++) {
            mapT[t.charAt(i) - 'a']++;
        }

        for (; right < s.length(); right++) {
            mapS[s.charAt(right) - 'a']++;

            while (isMatched(mapS, mapT)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                mapS[s.charAt(left++) - 'a']--;
            }
        }


        System.out.println(minLen);
        System.out.println(minStart);
    }

    private static boolean isMatched(int[] mapS, int[] mapT) {
        for (int i = 0; i < 256; i++) {
            if (mapT[i] > mapS[i]) {
                return false;
            }
        }
        return true;
    }
}
