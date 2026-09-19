package org.array.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public void groupAnagram() {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};

        HashMap<String, List<String>> res = new HashMap<>();

        if (strs == null || strs.length == 0) {
            new ArrayList();
        }
        for (int i = 0; i < strs.length; i++) {
            String freqKey = getFreqKey(strs[i]);

            if (res.containsKey(freqKey)) {
                res.get(freqKey).add(strs[i]);
            } else {
                List<String> arr = new ArrayList();
                arr.add(strs[i]);
                res.put(freqKey, arr);
            }

        }
        System.out.println(new ArrayList(res.values()));
    }

    public static String getFreqKey(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for (int i : freq) {
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }
}
