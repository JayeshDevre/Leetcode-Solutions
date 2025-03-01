class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
            set.add(nums[i]);
            }else{
                continue;
            }
        }

        return set.size();
    }
}