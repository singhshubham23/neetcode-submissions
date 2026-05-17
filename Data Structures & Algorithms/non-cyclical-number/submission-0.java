class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getSum(n);
        }
        return n == 1;
    }
    public int getSum(int n){
        int s = 0;
        while(n > 0){
            int d = n%10;
            s += d*d;
            n = n/10;
        }
        return s;
    }
}
