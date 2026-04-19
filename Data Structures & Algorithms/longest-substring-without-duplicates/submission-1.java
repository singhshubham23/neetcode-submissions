class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] seen = new int[256];
        for(int i = 0; i < 256; i++){
            seen[i] = -1;
        }

        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char current = s.charAt(right);

            if(seen[current] >= left){
                left = seen[current]+1;
            }

            seen[current] = right;
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
