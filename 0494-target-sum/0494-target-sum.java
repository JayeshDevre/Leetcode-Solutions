class Solution {
     public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0);
    }
    private int solve(int [] nums, int target, int i){
        if(i == nums.length){
            if(target == 0)
                return 1;
            return 0;
        }
        return solve(nums, target - nums[i], i + 1) + solve(nums, target + nums[i], i + 1);
    }
}