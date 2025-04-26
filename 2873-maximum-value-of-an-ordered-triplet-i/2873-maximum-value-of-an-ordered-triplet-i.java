class Solution {
    public long maximumTripletValue(int[] nums) {
       long maxTriplet=0, maxDiff=0, maxNum=0;

       for(int num:nums){
        maxTriplet=Math.max(maxTriplet, maxDiff*num);
        maxDiff=Math.max(maxDiff,maxNum-num);
        maxNum=Math.max(maxNum, num);
       }

       return maxTriplet;
    }
}
