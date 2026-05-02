class Solution {
    public int findMin(int[] nums) {
    //     Arrays.sort(nums);
    //    return nums[0];
    if(nums[0] <= nums[nums.length-1]) return nums[0];

    int beginIndex = 1;
    int endIndex = nums.length-1;
        while(beginIndex <= endIndex){
            int index = (endIndex-beginIndex) / 2 + beginIndex;
            if(nums[index] > nums[0]){
                beginIndex = index + 1;
            }else{
                endIndex = index-1;
            }
        }
        return nums[beginIndex];
    }
}
