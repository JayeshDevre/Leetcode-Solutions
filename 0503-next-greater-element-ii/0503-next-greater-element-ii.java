class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int [] ans= new int[n];
        Arrays.fill(ans, -1);

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+n-1;j++){
                int index=j%n;

                if(nums[index]>nums[i]){
                    ans[i]=nums[index];
                    break;
                }
            }
        }
        return ans;
    }
}