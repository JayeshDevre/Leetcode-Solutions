class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int ans=0;
        int i=0;

        for(int j=0;j<nums.length;j++){
            if(nums[j]==1){
                ans++;
                max=Math.max(ans,max);
            }else{
                // j=j+1;
                ans=0;
            }
        }
        return max;
    }
}