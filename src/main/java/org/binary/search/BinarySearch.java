package org.binary.search;

public class BinarySearch {

    public void binarySearch() {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;
        int res = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                res = mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        //return -1;
    }
}
