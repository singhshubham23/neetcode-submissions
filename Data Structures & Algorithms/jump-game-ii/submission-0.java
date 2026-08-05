class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int n = nums.length-1;
        int curr = 0;
        int s = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            s = Math.max(s, i + nums[i]);
           if (i == curr) {
                cnt++;   
                curr = s; 
                if (curr >= n) {
                    break;
                }
            }
        }
        return cnt;
    }
}

