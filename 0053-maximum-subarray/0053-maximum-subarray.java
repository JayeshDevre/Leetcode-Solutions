class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int cursum=nums[0];
      
        for(int i=1;i<nums.length;i++){
           cursum= Math.max(nums[i], cursum+nums[i]);
           maxSum=Math.max(maxSum,cursum);
        }
        return maxSum;
    }
}