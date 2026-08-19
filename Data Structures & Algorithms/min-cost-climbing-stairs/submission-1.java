class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int p1 = 0;
        int p2 = 0;

        for(int i = 2; i <= n; i++){
            int current = Math.min(p1+cost[i-1], p2+cost[i-2]);
            p2 = p1;
            p1 = current;
        }
        return p1;
    }
}
