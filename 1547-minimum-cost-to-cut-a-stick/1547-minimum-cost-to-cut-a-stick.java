class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int [] nums= new int[m+2];
        nums[0]=0;
        nums[m+1]=n;
        Arrays.sort(cuts);
        int [][] dp= new int[m+2][m+2];
        for(int [] d: dp){
            Arrays.fill(d, -1);
        }

        for(int i=0;i<m;i++){
            nums[i+1]=cuts[i];
        }

        return solve(0,m+1,nums,dp);
    }

    private int solve(int i, int j, int[] arr, int[][] dp){
        if(j-i<=1){
            return 0;
        }
        int minCost=Integer.MAX_VALUE;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for(int k=i+1;k<j;k++){
           int cost =
                    arr[j] - arr[i]   // cost of current cut
                    + solve(i, k, arr, dp)
                    + solve(k, j, arr, dp);

            minCost = Math.min(minCost, cost);
        }
        return dp[i][j]=minCost;
    }
}