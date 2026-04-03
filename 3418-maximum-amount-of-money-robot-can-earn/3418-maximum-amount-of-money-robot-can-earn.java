class Solution {
    int m,n;
    Integer[][][] dp;
    public int maximumAmount(int[][] coins) {
        
        n=coins.length;
        m=coins[0].length;
        dp = new Integer[n][m][3];
        return calculate(coins, 0, 0, 2);
    }

    private int calculate(int [][] coins, int i, int j, int neu){
        if(i==n-1 && j==m-1){
            if(coins[i][j]<0 && neu>0){
                return 0;
            }
            return coins[i][j];
        }

        if(i>=n || j>=m){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j][neu]!=null){
            return dp[i][j][neu];
        }

        int take = coins[i][j]+ Math.max(calculate(coins, i+1,j,neu),calculate(coins, i, j+1, neu));

        int skip=Integer.MIN_VALUE;
        if(coins[i][j]<0 && neu>0){
            int skipDown=calculate(coins,i+1,j ,neu-1);
            int skipRight = calculate(coins,i,j+1,neu-1);

            skip=Math.max(skipDown, skipRight);
        }

        return dp[i][j][neu] = Math.max(take,skip);

    }
}