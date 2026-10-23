class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> middleList = new ArrayList<>();

        createSubset(returnList, middleList, nums, 0);

        returnList.add(new ArrayList<>());
        return returnList;
    }

    public void createSubset(List<List<Integer>> returnList, List<Integer> middleList, int[] nums, int index) {
        if (index == nums.length) return;
        
        middleList.add(nums[index]);
        returnList.add(new ArrayList<>(middleList));
        createSubset(returnList, middleList, nums, index + 1);
        middleList.removeLast();
        createSubset(returnList, middleList, nums, index + 1);
    }
}
