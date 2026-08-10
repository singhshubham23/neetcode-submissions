class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];

        for(int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int st = 0;
        int maxIdx = 0;

        for(int i = 0; i < s.length(); i++){
            maxIdx = Math.max(maxIdx, lastIndex[s.charAt(i)-'a']);

            if(i == maxIdx){
                result.add(i-st+1);
                st = i+1;
            }
        }
        return result;
    }
}
