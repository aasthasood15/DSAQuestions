package org.sliding.window;

public class BuySellStockStrategy {

    public void buySellStockWithStrategy() {
        int ans = 0;
        int originalSum = 0;
        int prefixSum = 0;

        int[] arr = {5, 2, 8, 11, 3, 9};
        int n = arr.length;
        int k = 4;

        int[] strategy = {0, 1, -1, -1, 1, 0};
        int[] originalSumArr = new int[n];
        int[] prefixSumArr = new int[n];

        for (int i = 0; i < n; i++) {
            originalSum = originalSum + arr[i];
            originalSumArr[i] = originalSum;

            prefixSum = prefixSum + arr[i] * strategy[i];
            prefixSumArr[i] = prefixSum;
        }

        ans = originalSum;

        for (int i = k - 1; i < n; i++) {
            int leftWithoutStrategySum = 0;
            int righWithoutStrategySum = 0;
            int withStrategyLastHalf = prefixSumArr[i] - prefixSumArr[i - k / 2];

            if (i - k >= 0) {
                leftWithoutStrategySum = originalSumArr[i-k];
            }
            righWithoutStrategySum = originalSumArr[n - 1] - originalSumArr[i];

            ans = Math.max(ans, righWithoutStrategySum + leftWithoutStrategySum + withStrategyLastHalf);
        }

        System.out.println(ans);

    }
}
