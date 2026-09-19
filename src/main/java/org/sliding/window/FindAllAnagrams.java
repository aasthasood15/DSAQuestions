package org.sliding.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public void findAllAnagrams(){
        String s ="cbaebabacd";
        String p ="abc";
        //   String s ="abab";
        //   String p ="ab";

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        List<Integer> result = new ArrayList<>();

        for (char c : p.toCharArray()){
            pCount[c-'a']++;
            sCount[c-'a']++;
        }
        if(Arrays.equals(sCount,pCount)){
            result.add(0);
        }

        for(int i=1;i<=s.length()-p.length();i++){
            sCount[s.charAt(i-1)-'a']--;
            sCount[s.charAt(i+p.length()-1)-'a']++;
            if(Arrays.equals(sCount,pCount)){
                result.add(i);
            }
        }
        System.out.println(result);



    }
}
