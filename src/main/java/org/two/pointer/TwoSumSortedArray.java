package org.two.pointer;

public class TwoSumSortedArray {

    private int[] twoSumSortedArray(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < target){
                left++;
            } else if (arr[left] + arr[right] > target) {
                right--;
            } else {
                return new int[]{left+1,right+1};// as per questions demand
            }

        }

        return new int[0];
    }
}
