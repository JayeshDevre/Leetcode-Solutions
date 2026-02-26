class Solution {
    public boolean canJump(int[] nums) {
        int LastIndex= nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=LastIndex){
                LastIndex=i;
            }
        }

        return LastIndex==0;
    }
}