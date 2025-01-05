class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length-1){
            int correctIndex=nums[i]-1;
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[correctIndex]){
                swap(nums,i,correctIndex);
            }else{
                i++;
            }
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }

     public static void swap(int arr[], int first, int second ){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}