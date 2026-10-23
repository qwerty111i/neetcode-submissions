class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> middleList = new ArrayList<>();

        createSubset(returnList, middleList, nums, 0);

        return returnList;
    }

    public void createSubset(List<List<Integer>> returnList, List<Integer> middleList, int[] nums, int index) {
        returnList.add(new ArrayList<>(middleList));
        
        for (int i = index; i < nums.length; i++) {
            middleList.add(nums[i]);
            createSubset(returnList, middleList, nums, i + 1);
            middleList.removeLast();
        }
    }
}
