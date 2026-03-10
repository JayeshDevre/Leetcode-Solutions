class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr= new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        int [][] dp= new int[n+1][n+1];
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }

        for(int [] d: dp){
            Arrays.fill(d, -1);
        }

        return helper(1, n, arr,dp);
    }

    private int helper(int i, int j, int [] arr, int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int maxCoins=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int coins= arr[i-1]*arr[k]*arr[j+1] + helper(i,k-1,arr,dp) + helper(k+1,j,arr,dp);

            maxCoins=Math.max(coins,maxCoins);

        }
        return dp[i][j]=maxCoins;
    }
}