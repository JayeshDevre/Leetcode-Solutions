class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int [] dp= new int[cost.length+1];
       Arrays.fill(dp,-1);
       return Math.min(solve(0,cost,dp),solve(1,cost,dp)); 
    }

    private int solve(int index, int[] cost, int[] dp){
        int n=cost.length;
        if(index>=n){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }

        int oneStep=cost[index]+solve(index+1,cost, dp);
        int twoStep=cost[index]+solve(index+2,cost, dp);

        return dp[index]= Math.min(oneStep, twoStep);
    }
}