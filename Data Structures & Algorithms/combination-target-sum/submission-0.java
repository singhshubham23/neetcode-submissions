class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain) {
                break; 
            }

            currentList.add(nums[i]);
            backtrack(result, currentList, nums, remain - nums[i], i);
            currentList.remove(currentList.size() - 1);
        }
    }
}