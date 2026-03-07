class Solution {
    public int minDistance(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp= new int[m+1][n+1];
        // for(int [] d: dp){
        //     Arrays.fill(d, -1);
        // }

        // return helper(m-1,n-1,word1, word2,dp);
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                }else{
                    dp[i][j]=1+ Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }             
            }
        }
        return dp[m][n];
    }

    private int helper(int i, int j, String s, String t, int[][] dp){
        if(i<0){
            return j+1;
        }

        if(j<0){
            return i+1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==t.charAt(j)){
            return helper(i-1,j-1,s,t,dp);
        }

        return 1+ Math.min(helper(i,j-1,s,t,dp), Math.min(helper(i-1,j-1,s,t,dp), helper(i-1,j,s,t,dp)));
    }
}