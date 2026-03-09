class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp= new int[n][amount+1];
        // for(int [] d: dp){
        //     Arrays.fill(d, -1);
        // }
        // return helper(n-1, amount, coins, dp);
        for(int t=0; t<=amount ; t++){
            if(t%coins[0]==0){
                dp[0][t]=1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake=dp[i-1][j];
                int take=0;
                if(coins[i]<=j){
                    take= dp[i][j-coins[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[n-1][amount];
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