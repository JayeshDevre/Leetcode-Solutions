class Solution {
    int m,n;
    public int maximumAmount(int[][] coins) {
        m=coins.length;
        n=coins[0].length;
        return helper(coins, 0,0, 2);
    }

    private int helper(int [][] coins , int i, int j, int neu){
        if(i==m-1 && j==n-1){
            if(coins[i][j]<0 && neu>0){
                return 0;
            }
            return coins[i][j];
        }

        if(i>=m || j>=n){
            return Integer.MIN_VALUE;
        }

        int take=coins[i][j]+ Math.max(helper(coins,i+1,j,neu), helper(coins,i,j+1,neu));

        int skip=Integer.MIN_VALUE;
        if(coins[i][j]<0 && neu>0){
            int skipdown=helper(coins,i+1,j,neu-1);
            int skipright=helper(coins,i,j+1,neu-1);
            skip=Math.max(skipdown, skipright);
        }

        return Math.max(skip,take);
    }
}