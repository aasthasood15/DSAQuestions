package org.array.hashing;

import java.util.HashMap;

public class NiceArrays {

    public int getNumberOfNiceArrays(){

        //Input: nums = [1,1,2,1,1], k = 3

        int[] nums = {1,1,2,1,1};
        int k=3;

        int currSum = 0;
        int count = 0;

        HashMap<Integer,Integer> freqSumMap = new HashMap<>();
        freqSumMap.put(0,1);
        for(int num : nums){
            currSum = currSum + num%2;
            if(freqSumMap.containsKey(currSum-k)){
                count = count + freqSumMap.get(currSum-k);
            }
            freqSumMap.put(currSum, freqSumMap.getOrDefault(currSum,0)+1);
        }

        return count;
    }
}
