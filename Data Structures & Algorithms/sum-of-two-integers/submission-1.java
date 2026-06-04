class Solution {
    public int getSum(int a, int b) {
        int t = a;
        while(b != 0){
            int s = t ^ b;
            int c = (t & b) << 1;
            t = s;
            b = c;
        }
        return t;
    }
}
