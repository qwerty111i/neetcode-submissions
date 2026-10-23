class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int rowLength = matrix[0].length - 1;

        int row = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > matrix[mid][rowLength]) {
                left = mid + 1;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else {
                row = mid;
                break;
            }
        }

        left = 0;
        right = rowLength;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > matrix[row][mid]) {
                left = mid + 1;
            } else if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
