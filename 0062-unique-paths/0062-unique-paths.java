class Solution {
    public int uniquePaths(int m, int n) {
        int [][]  dp = new int[m+1][n+1];
        // for(int [] d: dp){
        //     Arrays.fill(d,-1);
        // }
        // return helper(m-1,n-1,dp);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    private int helper(int i,int j, int [][] dp){

        if(i==0 && j==0){
            return 1;
        }

        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int left=helper(i,j-1,dp);
        int up=helper(i-1,j,dp);
        return dp[i][j]= up+left;
    }
}