class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer < rightPointer) {
            if (numbers[leftPointer] + numbers[rightPointer] > target) {
                rightPointer--;
            } else if (numbers[leftPointer] + numbers[rightPointer] < target) {
                leftPointer++;
            } else {
                return new int[] {leftPointer + 1, rightPointer + 1};
            }
        }

        return new int[] {};
    }
}
