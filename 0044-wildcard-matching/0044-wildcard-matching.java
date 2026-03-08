class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        Boolean [][] dp= new Boolean [m][n];
        return helper(m-1, n-1, s,p,dp);
    }

    private boolean helper(int i, int j, String s, String p, Boolean [][] dp){

        if(i<0 && j<0){
            return true;
        }

        if(i>=0 && j<0){
            return false;
        }

        if(i<0 && j>=0){
            for(int ii=0;ii<=j;ii++){
                if(p.charAt(ii)!='*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]= helper(i-1, j-1, s, p,dp);
        }

        if(p.charAt(j)=='*'){
            return dp[i][j]= helper(i-1,j,s,p,dp) || helper(i,j-1,s,p,dp);
        }

        return dp[i][j]=false;
    }
}