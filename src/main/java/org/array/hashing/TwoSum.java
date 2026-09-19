package org.array.hashing;

import java.util.HashMap;

public class TwoSum {
    public void twoSum(){
        int[] nums = {3,4,5,6};
        int target = 7;
        int[] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            if(hm.containsKey(target-nums[i])){
                res[0] = hm.get(target-nums[i]);
                res[1] = i;
            }
            hm.put(nums[i], i);
        }
        System.out.println(res[0]+" "+res[1]);
    }
}
