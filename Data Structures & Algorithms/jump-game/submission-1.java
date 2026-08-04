class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int s = 0;
        for(int i = 0; i < n; i++){
            if(i > s){
                return false;
            }
            s = Math.max(s, i+nums[i]);
            if(s >= n-1){
                return true;
            } 
        }
        return true;
    }
}
