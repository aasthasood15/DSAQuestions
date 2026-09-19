package org.array.hashing;

public class LargestElement {
    public static Integer findLargest(int[] arr) {
        if (arr == null || arr.length == 0) return null; // or throw
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
}
