class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][] dp=new int[n][amount+1];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }

        int ans=calculate(n-1,amount, coins,dp);
        if(ans==1e9){
            return -1;
        }
        return ans;
    }

    private int calculate(int index, int target, int [] coins, int [][] dp){
        int INF=(int)1e9;
        if(index==0){
            if(target%coins[index]==0){
                return target/coins[index];
            }
            return INF;
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int notTake=0+calculate(index-1,target,coins,dp);
        int take=INF;
        if(coins[index]<=target){
            take=1+calculate(index,target-coins[index],coins,dp);
        }
        return dp[index][target]=Math.min(take, notTake);
    }
}