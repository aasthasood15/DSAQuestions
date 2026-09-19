package org.array.hashing;

public class SecondLargest {
    public static Integer secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) return null; // or throw

        Integer largest = null, second = null;
        for (int x : arr) {
            if (largest == null || x > largest) {
                second = largest;
                largest = x;
            } else if (x != largest && (second == null || x > second)) {
                second = x;
            }
        }
        return second; // null if no distinct second largest exists
    }
}
