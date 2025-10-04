class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;

        for(int i:nums){
            count=count+i;
            max=Math.max(count,max);
            if(i==0){
                count=0;
            }
        }
        return max;
    }
}