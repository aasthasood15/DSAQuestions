package org.sliding.window;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacters {

    public void longestSubStringWithoutRepeatingCharacters() {
        {
            String s ="abcdcdea";
            int n = s.length();
            HashMap<Character,Integer> map = new HashMap<>();
            int start = 0;
            int i = 0;
            int maxLength = Integer.MIN_VALUE;

            while(i < n){
                if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>=start){
                    start = map.get(s.charAt(i)) + 1;
                }
                map.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, i-start+1);
                i++;
            }

            System.out.println(maxLength);


        }
    }
}
