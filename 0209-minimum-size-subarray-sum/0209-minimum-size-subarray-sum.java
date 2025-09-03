class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minWindowSize=Integer.MAX_VALUE;
        int low=0;
        int high=0;
        int currentSum=0;

        while(high<nums.length){
            currentSum+=nums[high];
            high++;

            while(currentSum>=target){
                int currentWindowSize=high-low;
                minWindowSize=Math.min(minWindowSize,currentWindowSize);
                currentSum=currentSum-nums[low];
                low++;
            }
        }
        return minWindowSize==Integer.MAX_VALUE?0:minWindowSize;
    }
}