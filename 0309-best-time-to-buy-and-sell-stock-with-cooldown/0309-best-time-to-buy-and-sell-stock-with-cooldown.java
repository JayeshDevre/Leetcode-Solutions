class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int [][] dp= new int[n+1][2];
        for(int [] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(0,1,prices,n,dp);
    }

    private int helper(int ind,int buy, int[] prices, int n, int[][] dp ){
        if(ind>=n){
            return 0;
        }
        int profit=0;
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        if(buy==1){
            profit= Math.max(-prices[ind]+helper(ind+1, 0 , prices, n, dp), 0+helper(ind+1,1,prices,n, dp));
        }else{
            profit= Math.max(prices[ind]+helper(ind+2, 1 , prices, n, dp), 0+helper(ind+1,0,prices,n, dp));
        }

        return dp[ind][buy] = profit;
    }
}