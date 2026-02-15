class Solution {
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }

        int [] skipFirst=new int[nums.length-1];
        int [] skipLast= new int[nums.length-1];

        for(int i=0;i<nums.length-1;i++){
            skipFirst[i]=nums[i];
            skipLast[i]=nums[i+1];
        }

        int nf=helper(skipFirst);
        int nl=helper(skipLast);

        return Math.max(nl,nf);
    }

    private int helper(int[] nums){
        int prev1=0;
        int prev2=0;

        for(int num: nums){
            int curr=Math.max(num+prev2, prev1);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}