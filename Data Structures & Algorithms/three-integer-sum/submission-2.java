class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int pointerA = i + 1;
            int pointerB = nums.length - 1;

            while (pointerA < pointerB) {
                if (nums[i] + nums[pointerA] + nums[pointerB] > 0) {
                    pointerB--;
                } else if (nums[i] + nums[pointerA] + nums[pointerB] < 0) {
                    pointerA++;
                } else {
                    outputList.add(new ArrayList<>(List.of(nums[i], nums[pointerA], nums[pointerB])));
                    pointerA++;
                    pointerB--;

                    while (pointerA < pointerB && nums[pointerA] == nums[pointerA - 1]) {
                        pointerA++;
                    }
                }
            }
        }

        return outputList;
    }
}
