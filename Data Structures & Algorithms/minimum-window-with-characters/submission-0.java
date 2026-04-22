class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        int[] dicT = new int[128];
        for(char c : t.toCharArray()) dicT[c]++;

        int req = 0;
        for(int cnt : dicT){
            if(cnt > 0) req++;
        }

        int l = 0, r = 0;
        int formed = 0;
        int[] windowsCount = new int[128];

        int[] ans = {-1, 0, 0};

        while(r < s.length()){
            char c = s.charAt(r);
                windowsCount[c]++;

                if(dicT[c] > 0 && windowsCount[c] == dicT[c]){
                    formed++;
                }

                while(l <= r && formed == req){
                    c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowsCount[c]--;

                if(dicT[c] > 0 && windowsCount[c] < dicT[c]){
                    formed--;
                }
            l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
