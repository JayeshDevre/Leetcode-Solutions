class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum=nums[0];
        int currSum=nums[0];

        for(int i=1;i<nums.length;i++){
            // continue ascending sequence
            if(nums[i]>nums[i-1]){
                currSum=currSum+nums[i];
            }else{
                // Reset Window
                currSum=nums[i];
            }
            maxSum=Math.max(maxSum,currSum);
        }

        return maxSum;
    }
}