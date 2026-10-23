class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> middleList = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];

        permuteRecursive(nums, returnList, middleList, isUsed);

        return returnList;
    }

    public void permuteRecursive(int[] nums, List<List<Integer>> returnList, List<Integer> middleList, boolean[] isUsed) {
        if (middleList.size() == nums.length) {
            returnList.add(new ArrayList<>(middleList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;

            isUsed[i] = true;
            middleList.add(nums[i]);

            permuteRecursive(nums, returnList, middleList, isUsed);

            isUsed[i] = false;
            middleList.removeLast();
        }
    }
}
