class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1];
        int cnt = 1;

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= end){
                cnt++;
                end = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}
