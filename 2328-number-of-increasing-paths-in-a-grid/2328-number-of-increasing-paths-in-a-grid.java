class Solution {
    private int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
    private int m, n;
    private static final int mod=(int)1e9+7;
    public int countPaths(int[][] grid) {
        int ans=0;
        m=grid.length;
        n=grid[0].length;
        int [][] dp =new int[m+1][n+1];
        for(int []d : dp){
            Arrays.fill(d,-1);
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans=(ans+solve(i,j, grid,dp))%mod;
            }
        }
        return ans;
    }

    private int solve(int i, int j, int[][] grid, int[][] dp){
        int result=1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for(int [] d: directions){
            int i_=i+d[0];
            int j_=j+d[1];
            if(i_>=0 && j_>=0 && i_<grid.length && j_<grid[0].length && grid[i_][j_]<grid[i][j]){
                result=(result+solve(i_,j_,grid,dp))%mod;
            }
        }
        return dp[i][j]=result;
    }
}