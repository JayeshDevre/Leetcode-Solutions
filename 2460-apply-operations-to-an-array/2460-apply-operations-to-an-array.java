class Solution {
    public int[] applyOperations(int[] nums) {
        int arr[] =new int[nums.length];
        int count=0;
        int i=0;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]!=0){
                if(nums[i]==nums[i+1]){
                    arr[count]=nums[i]*2;
                    i++;
                }else{
                    arr[count]=nums[i];   
                }
                count++;
            }
        }
        if(i!=nums.length){
            arr[count]= nums[nums.length-1];
        }
        return arr;
    }
}