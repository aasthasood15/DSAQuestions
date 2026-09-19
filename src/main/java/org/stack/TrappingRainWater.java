package org.stack;


public class TrappingRainWater {
    public void trappingRainWater() {
        int[] arr = {4, 12, 5, 3, 1, 2, 5};
        int ans = 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            ans += Math.min(left[i], right[i]) - arr[i];
        }
        System.out.println(ans);

    }

}
