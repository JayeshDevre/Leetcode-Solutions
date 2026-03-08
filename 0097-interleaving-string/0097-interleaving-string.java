class Solution {
    private int m,n;
    public boolean isInterleave(String s1, String s2, String s3) {
        m=s1.length();
        n=s2.length();
        if(m+n!=s3.length()){
            return false;
        }
        Boolean [][] dp= new Boolean[m+1][n+1];
        return helper(0, 0, s1, s2, s3, dp);
    }

    private boolean helper(int i, int j, String s1, String s2, String s3, Boolean[][] dp){
        if(i==m && j==n ){
            return true;
        }
        if( dp[i][j]!=null){
            return dp[i][j];
        }
        boolean result=false;
        int k=i+j;
        if(i<m && s1.charAt(i)==s3.charAt(k)){
            result=helper(i+1,j,s1,s2,s3,dp);
        } 
        if(!result && j<n && s2.charAt(j)==s3.charAt(k)){
            result=helper(i,j+1,s1,s2,s3,dp);
        }
        return dp[i][j]=result;
    }
}