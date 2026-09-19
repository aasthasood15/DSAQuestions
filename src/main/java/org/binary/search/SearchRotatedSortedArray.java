package org.binary.search;

import java.util.Comparator;

public class SearchRotatedSortedArray {
    public void searchRotatedSortedArray() {
        int[] num = {3, 4, 5, 6, 1, 2};
        int target = 6;

        System.out.println(binarySearchRotatedArray(0, num.length - 1, num, target));
    }

    private static int binarySearchRotatedArray(int low, int high, int[] num, int target) {

        if (low > high)
            return -1;//Not Found

        int mid = low + (high - low) / 2;
        if (num[mid] == target) {
            return mid;//Found
        }
        if (num[mid] >= num[low]) {
            // left array is sorted
            if (num[low] <= target && num[mid] >= target) {

                return binarySearchRotatedArray(low, mid - 1, num, target);
            } else {
                return binarySearchRotatedArray(mid + 1, high, num, target);
            }

        } else {
            // right array is sorted
            if (num[mid] <= target && num[high] >= target) {
                return binarySearchRotatedArray(mid + 1, high, num, target);
            } else {
                return binarySearchRotatedArray(low, mid - 1, num, target);
            }

        }

    }
}
