class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] > -nums[i]) right--;
                else if (nums[left] + nums[right] < -nums[i]) left++;
                else if (nums[left] + nums[right] == -nums[i]) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);

                    returnList.add(arr);

                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }

        return returnList;
    }
}
