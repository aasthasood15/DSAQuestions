package org.sliding.window;

public class LongestRepeatingCharacterReplacement {

    private void longestRepeatingCharacterReplacement() {
        String s = "aababcc";
        s=s.toLowerCase();// otherwise it gives index out of bound exception
        int k = 2;
        int maxFreq = 0;
        int windowSize = 0;
        int windowMax = 0;
        int left = 0;
        int right = 0;
        int[] mapS = new int[26];

        while (right < s.length()) {
            mapS[s.charAt(right) - 'a']++;
            maxFreq = Math.max(maxFreq, mapS[s.charAt(right) - 'a']);
            if (right - left + 1 - maxFreq > k) {
                mapS[s.charAt(left) - 'a']--;
                left++;
            }


            windowSize = right - left + 1;
            windowMax = Math.max(windowMax, windowSize);
            right++;
        }

        System.out.println(windowMax);
    }
}
