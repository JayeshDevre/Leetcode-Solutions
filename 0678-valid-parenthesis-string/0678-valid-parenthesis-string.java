class Solution {
    public boolean checkValidString(String s) {
        int n= s.length();
        Boolean [][] dp =new Boolean[n+1][n+1];
        return solve(0,0,s,n, dp);
    }

    private boolean solve(int index, int open, String s, int n, Boolean [][] dp){
        if(index==n){
            return open==0;
        }

        if(dp[index][open]!=null){
            return dp[index][open];
        }

        boolean ans=false;
        if(s.charAt(index)=='('){
            ans = solve(index+1,open+1,s,n,dp);
        }else if(s.charAt(index)=='*'){
            ans = solve(index+1, open+1,s,n,dp) || solve(index+1,open,s,n,dp) || (open>0 && solve(index+1,open-1,s,n,dp));
        }else{
            if(open>0){
                ans = solve(index+1,open-1,s,n,dp); 
            }
        }
        return dp[index][open]=ans;
    }
}