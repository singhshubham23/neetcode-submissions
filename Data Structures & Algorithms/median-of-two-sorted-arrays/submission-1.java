class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
       int m = nums1.length, n = nums2.length;
       int low = 0, high = m;

       while(low <= high){
         int x = (low+high)/2;
       int y = (m+n+1)/2 - x;

       int mLx = (x == 0) ? Integer.MIN_VALUE : nums1[x-1];
       int mRx = (x == m) ? Integer.MAX_VALUE : nums1[x];

       int mLy = (y == 0) ? Integer.MIN_VALUE : nums2[y-1];
       int mRy = (y == n) ? Integer.MAX_VALUE : nums2[y];

       if(mLx <= mRy && mLy <= mRx){
        if((m+n)%2 == 0){
            return ((double)Math.max(mLx, mLy) + Math.min(mRx, mRy)) / 2; 
        }else{
            return (double)Math.max(mLx, mLy);
        }
       }else if(mLx > mRy){
        high = x-1;
       }else{
        low = x+1;
       }
       }
      
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
