package org.array.hashing;

import java.util.Arrays;

public class ValidAnagram {
    public void validAnagram() {
        String s = "racecar", t = "carrace";
        boolean res = false;

        int[] mapS = new int[26];
        int[] mapT = new int[26];

        for (char c : s.toCharArray()) {
            mapS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            mapT[c - 'a']++;
        }
        if (Arrays.equals(mapS, mapT)) {
            res = true;
        }
        System.out.println(res);
    }
}
