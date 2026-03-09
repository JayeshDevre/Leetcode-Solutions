class Solution {
    private int m,n;
    private int[][] directions= {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int ans=0;
        m=matrix.length;
        n=matrix[0].length;

        int[][] dp = new int[m][n];
        for(int [] d: dp){
            Arrays.fill(d,-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dfs(i,j,matrix,dp));
            }
        }

        return ans;
    }

    private int dfs(int i, int j, int[][] matrix, int [][] dp){
        int result=1;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        for(int [] d: directions){
            int i_=i+d[0];
            int j_=j+d[1];

            if(i_>=0 && j_>=0 && i_<m && j_<n && matrix[i_][j_]<matrix[i][j]){
                result=Math.max(result, 1+dfs(i_,j_,matrix,dp));
            }
        }
        return dp[i][j]=result;
    }

}