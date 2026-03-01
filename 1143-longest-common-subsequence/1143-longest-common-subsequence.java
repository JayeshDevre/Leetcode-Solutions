class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int [][] dp = new int[m+1][n+1];
        // for(int []d: dp){
        //     Arrays.fill(d, -1);
        // }
        // return helper(m-1, n-1, text1, text2, dp);

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                dp[i][j] = 1+dp[i-1][j-1];
            }else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
             }
        }
        return dp[m][n];
    }

    private int helper(int i, int j, String s1, String s2, int [][] dp){

        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1+helper(i-1, j-1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(helper(i-1,j,s1,s2,dp), helper(i, j-1, s1, s2, dp));
    }
}