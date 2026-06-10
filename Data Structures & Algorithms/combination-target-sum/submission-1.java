class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> currList, int[] nums,int remain, int start){
        if(remain == 0){
            result.add(new ArrayList<>(currList));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(nums[i] > remain){
                break;
            }
            currList.add(nums[i]);
            backtrack(result, currList, nums, remain-nums[i], i);
            currList.remove(currList.size()-1);
        }
    }
   
}