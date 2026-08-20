class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int h1 = 0;
        int h2 = 0;

        for(int i = 0; i < nums.length; i++){
            int profit = Math.max(h1, h2+nums[i]);
            h2 = h1;
            h1 = profit;
        }
        return h1;
    }
}