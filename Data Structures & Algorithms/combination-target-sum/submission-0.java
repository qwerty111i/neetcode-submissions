class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> middleList = new ArrayList<>();

        combinationCalc(0, nums, 0, target, middleList, returnList);

        return returnList;
    }

    public void combinationCalc(int index, int[] nums, int currSum, int target, List<Integer> middleList, List<List<Integer>> returnList) {
        if (index == nums.length || currSum > target) return;
        if (currSum == target) {
            returnList.add(new ArrayList<>(middleList));
            return;
        }

        middleList.add(nums[index]);
        combinationCalc(index, nums, currSum + nums[index], target, middleList, returnList);
        
        middleList.removeLast();
        combinationCalc(index + 1, nums, currSum, target, middleList, returnList);
    }
}
