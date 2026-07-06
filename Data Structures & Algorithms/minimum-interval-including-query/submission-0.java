class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int q = queries.length;

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        int[][] indexedQueries = new int[q][2];

        for(int i = 0; i < q; i++){
            indexedQueries[i][0] = queries[i];
            indexedQueries[i][1] = i;
        }

        Arrays.sort(indexedQueries, (a,b)-> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int[] result = new int[q];
        int intervalIdx = 0;

        for(int i = 0; i < q; i++){
            int queryValue = indexedQueries[i][0];
            int originalIdx = indexedQueries[i][1];
            
            while(intervalIdx  < n && intervals[intervalIdx][0] <= queryValue){
                int left = intervals[intervalIdx][0];
                int right = intervals[intervalIdx][1];
                int size = right - left + 1;
                minHeap.offer(new int[]{size, right});
                intervalIdx++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < queryValue){
                minHeap.poll();
            }

            if(!minHeap.isEmpty()){
                result[originalIdx] = minHeap.peek()[0];
            }else{
                result[originalIdx] = -1;
            }
        }
        return result;
    }
}
