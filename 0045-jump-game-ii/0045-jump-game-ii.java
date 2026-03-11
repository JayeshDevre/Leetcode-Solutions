class Solution {
    public int jump(int[] nums) {
        // 2,3,1,1,4
        // 0 1 2 3 4
        //     f   f
        // c
        int far=0;
        int cur=0;
        int j=0;
        // f=2
        for(int i=0;i<nums.length-1; i++){
            far=Math.max(far, i+nums[i]);
            if(i==cur){
                j++;
                cur=far;
            }        
        }
        return j;
    }
}