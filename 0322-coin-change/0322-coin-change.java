class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int ans=calculate(n-1,amount, coins);
        if(ans==1e9){
            return -1;
        }
        return ans;
    }

    private int calculate(int index, int target, int [] coins){
        int INF=(int)1e9;
        if(index==0){
            if(target%coins[index]==0){
                return target/coins[index];
            }
            return INF;
        }
        int notTake=0+calculate(index-1,target,coins);
        int take=INF;
        if(coins[index]<=target){
            take=1+calculate(index,target-coins[index],coins);
        }
        return Math.min(take, notTake);
    }
}