class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp= new int[n+1][amount+1];
        for(int [] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(n-1, amount, coins, dp);
    }

    private int helper(int index, int amount, int[] coins, int [][] dp){
        if(index==0){
            if(amount%coins[0]==0){
                return 1;
            }
            return 0;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }

        int notTake=helper(index-1, amount, coins, dp);
        int take=0;
        if(coins[index]<=amount){
            take= helper(index, amount-coins[index], coins, dp);
        }

        return dp[index][amount]= take+notTake;
    }
}