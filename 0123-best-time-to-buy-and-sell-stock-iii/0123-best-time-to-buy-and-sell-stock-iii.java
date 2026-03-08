class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][] dp = new int[n+1][4];
        for(int [] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(0,0,prices, n, dp);
    }

    private int helper(int ind, int transaction, int[] prices, int n, int [][] dp){
        if(ind==n || transaction == 4){
            return 0;
        }

        int profit = 0;

        if(dp[ind][transaction]!=-1){
            return dp[ind][transaction];
        }
        if(transaction%2==0){
            profit=Math.max(-prices[ind]+helper(ind+1,transaction+1, prices, n, dp), 0+helper(ind+1,transaction, prices, n, dp));
        }else{
            profit=Math.max(prices[ind]+helper(ind+1,transaction+1, prices, n, dp), 0+helper(ind+1,transaction, prices, n, dp));
        }
        return dp[ind][transaction]= profit;
    }
}