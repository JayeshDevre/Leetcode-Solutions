class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int [][] dp= new int[m+1][n+1];
        for(int [] d: dp){
            Arrays.fill(d,-1);
        }

        return helper(m-1,n-1,grid,dp);
    }

    private int helper(int i, int j, int [][] grid, int [][] dp){
        if(i==0 && j==0){
            return grid[i][j];
        }

        if(i<0 || j<0){
            return (int)1e9;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up=grid[i][j]+ helper(i-1,j,grid,dp);
        int left=grid[i][j]+helper(i,j-1,grid,dp);

        return dp[i][j]=Math.min(up,left);
    }
}