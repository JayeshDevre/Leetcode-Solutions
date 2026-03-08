class Solution {
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        int[][]dp= new int[n][k*2];
        for(int [] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(0,0,prices,n, k, dp);
    }

    private int helper(int ind, int transactions, int [] prices, int n, int k, int[][] dp){
        if(ind==n || transactions==k*2){
            return 0;
        }
        int profit=0;
        if(dp[ind][transactions]!=-1){
            return dp[ind][transactions];
        }
        if(transactions%2==0){
            profit=Math.max(-prices[ind]+helper(ind+1, transactions+1, prices, n, k, dp), 0+helper(ind+1,transactions,prices, n, k, dp));
        }else{
            profit= Math.max(prices[ind]+helper(ind+1, transactions+1, prices, n, k, dp), 0+helper(ind+1,transactions, prices, n, k, dp));
        }

        return dp[ind][transactions]= profit;
    }
}