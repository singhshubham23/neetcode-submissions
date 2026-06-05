class Solution {
    public double myPow(double x, int n) {
        if ( n == 0) return 1;
        if(x == 0) return 0;
        return Math.pow(x, n);
    }
}
