class Solution {
    public int jump(int[] nums) {
        int lastIndex=nums.length-1;
        int coverage=0;
        int lastjumpIdx=0;
        int totaljumps=0;

        if(nums.length==1){
            return 0;
        }

        for(int i=0;i<lastIndex;i++){
            coverage = Math.max(coverage, i+nums[i]);

            if(i==lastjumpIdx){
                lastjumpIdx=coverage;
                totaljumps++;
                if(coverage>=lastIndex){
                return totaljumps;
            }
            }

            

        }
        return totaljumps;

    }
}