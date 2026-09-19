package org.binary.search;

public class FindMinRotatedSortedArray {

    public void findMinRotatedSortedArray() {

        int[] num = {3, 4, 5, 6, 1, 2};
        int low = 0;
        int high = num.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] > num[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(num[low]);

    }
}
