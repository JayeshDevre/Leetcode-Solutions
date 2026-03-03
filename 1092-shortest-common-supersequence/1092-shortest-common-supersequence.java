class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();

        int [][] dp= new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        StringBuilder str=new StringBuilder();

        while(m>0 && n>0){
            if(str1.charAt(m-1)==str2.charAt(n-1)){
                str.append(str1.charAt(m-1));
                m--;
                n--;
            }else if(dp[m-1][n]>dp[m][n-1]){
                str.append(str1.charAt(m-1));
                m--;
            }else{
                str.append(str2.charAt(n-1));
                n--;
            }
        }

        while(m>0){
            str.append(str1.charAt(m-1));
            m--;
        }
        while(n>0){
            str.append(str2.charAt(n-1));
            n--;
        }
        return str.reverse().toString();
    }
}