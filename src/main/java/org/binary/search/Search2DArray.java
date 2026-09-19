package org.binary.search;

public class Search2DArray {

    public void searchArray() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 11;
        int row = findPotentialRow(matrix, target);
        if (row != -1) {

            System.out.println(searchForTarget(matrix, target, row));
        } else {
            System.out.println(false);
        }
    }

    private static int findPotentialRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                return mid;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else if (target > matrix[mid][0]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static boolean searchForTarget(int[][] matrix, int target, int row) {

        int low = 0;
        int high = matrix[row].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } else if (matrix[row][mid] < target) {
                low = mid + 1;
            }
        }
        return false;
    }
}
