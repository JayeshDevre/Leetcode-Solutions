class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low=0;
        int high=0;
        int minWindowSize=Integer.MAX_VALUE;
        int currSum=0;

        while(high<nums.length){
            currSum+=nums[high];
            high++;

            while(currSum>=target){
                int currentWindow=high-low;
                minWindowSize=Math.min(minWindowSize,currentWindow);
                currSum-=nums[low];
                low++;
            }
        }

        return minWindowSize==Integer.MAX_VALUE?0:minWindowSize;

    }
}