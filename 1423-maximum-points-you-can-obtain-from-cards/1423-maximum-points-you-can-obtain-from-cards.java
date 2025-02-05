class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum=0;
        int leftSum=0;
        int rightSum=0;
        for(int i=0;i<k;i++){
            leftSum=leftSum+cardPoints[i];
            maxSum=leftSum;
        }
        int rightIndex= cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum=leftSum-cardPoints[i];
            rightSum=cardPoints[rightIndex]+rightSum;
            rightIndex-=1;

            maxSum=Math.max(maxSum,leftSum+rightSum);
        }

        return maxSum;
    }
}