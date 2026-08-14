class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];

        for(int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        int st = 0;
        int maxI = 0;

        for(int i = 0; i < s.length(); i++){
            maxI = Math.max(maxI, lastIndex[s.charAt(i)-'a']);

            if(i == maxI){
                result.add(i-st+1);
                st = i+1;
            }
        }
        return result;
    }
}
