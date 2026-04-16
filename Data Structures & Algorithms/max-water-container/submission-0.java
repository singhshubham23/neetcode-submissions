class Solution {
    public int maxArea(int[] heights) {
        int ans=0;
        int i = 0, j = heights.length-1;
        while(i < j){
            int h = Math.min(heights[i], heights[j]);
            int w = j-i;
            int area = h*w;
            ans = Math.max(area, ans);
            if(heights[i] < heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
}
