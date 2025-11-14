class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }

        int maxProfit=0;
        int buyPrice=prices[0];

        for(int i=1;i<prices.length;i++){
            if(prices[i]<buyPrice){
                buyPrice=prices[i];
            }else{
                int profit=prices[i]-buyPrice;
                maxProfit=Math.max(profit,maxProfit);
            }
        }

        return maxProfit;
    }
}