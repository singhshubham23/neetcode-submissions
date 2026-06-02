class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(int task : tasks){
            cnt[task - 'A']++;
        }
        Arrays.sort(cnt);
        int maxFreq = cnt[25];

        int maxFreqCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] == maxFreq) {
                maxFreqCount++;
            } else {
                break; 
            }
        }
        int formulaResult = (maxFreq - 1) * (n + 1) + maxFreqCount;
        return Math.max(formulaResult, tasks.length);
    }
}
