class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp = new int[m+1][n+1];
        for(int [] d: dp){
            Arrays.fill(d, -1);
        }
        return helper(m-1, n-1, s, t, dp);
    }

    private int helper(int i, int j, String s, String t, int[][] dp){
        if(j<0){
            return 1;
        }

        if(i<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= helper(i-1,j-1, s, t,dp) + helper(i-1, j, s, t,dp);
        }

        return dp[i][j]=helper(i-1,j, s, t,dp);
    }
}