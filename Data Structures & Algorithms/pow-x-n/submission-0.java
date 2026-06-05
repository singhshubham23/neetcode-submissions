class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || n == 0) return 1;
        return Math.pow(x, n);
    }
}
