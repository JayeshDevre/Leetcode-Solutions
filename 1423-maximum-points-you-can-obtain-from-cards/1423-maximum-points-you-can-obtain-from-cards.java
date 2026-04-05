class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int rightSum=0;
        int maxSum=0;

        for(int i=0;i<k;i++){
            sum=sum+cardPoints[i];
            maxSum=Math.max(maxSum,sum);
        }
        int right=cardPoints.length-1;

        for(int i=k-1; i>=0; i--){
            sum=sum-cardPoints[i];
            sum=sum+cardPoints[right];
            right--;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}