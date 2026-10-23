class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> inputList = new ArrayList<>();

        addSet(returnList, inputList, 0, nums);
        return returnList;
    }

    public void addSet(List<List<Integer>> returnList, List<Integer> inputList, int index, int[] nums) {
        if (index == nums.length) {
            returnList.add(new ArrayList<>(inputList));
            return;
        }

        inputList.add(nums[index]);
        addSet(returnList, inputList, index + 1, nums);
        inputList.removeLast();
        addSet(returnList, inputList, index + 1, nums);
    }
}
