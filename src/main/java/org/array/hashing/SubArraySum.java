package org.array.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);

        int result = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            if (sumCountMap.containsKey(prefixSum - k)) {
                result = result + sumCountMap.get(prefixSum - k);
            }

            sumCountMap.put(prefixSum,
                    sumCountMap.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
}
