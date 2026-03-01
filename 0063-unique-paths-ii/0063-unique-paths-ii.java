class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length-1;
        int n=obstacleGrid[0].length-1;
        int [][] dp= new int[m+1][n+1];
        for(int [] d: dp){
            Arrays.fill(d,-1);
        }

        return helper(obstacleGrid, m, n, dp);
    }

    private int helper(int [][] grid, int i, int j, int [][] dp){

        if(i>=0 && j>=0 && grid[i][j]==1){
            return 0;
        }

        if(i==0 && j==0){
            return 1;
        }

        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up=helper(grid, i-1, j, dp);
        int left=helper(grid, i, j-1, dp);
        return dp[i][j]= up+left;
    }
}