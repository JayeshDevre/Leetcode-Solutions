class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;

        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<0){
                sum=0;
            }

            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;
    }
}