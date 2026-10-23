class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;

        while (leftPointer < rightPointer) {
            int area = Math.min(heights[leftPointer], heights[rightPointer]) * (rightPointer - leftPointer);
            if (maxArea < area) maxArea = area;

            if (heights[leftPointer] <= heights[rightPointer]) {
                leftPointer++;
            } else if (heights[leftPointer] > heights[rightPointer]) {
                rightPointer--;
            }
        }

        return maxArea;
    }
}
