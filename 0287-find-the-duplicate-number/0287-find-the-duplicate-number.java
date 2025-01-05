class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swap(nums,i,correctIndex);
            }else{
                i++;
            }
        }

        return nums[nums.length-1];
    }

     public void swap(int arr[], int first, int second ){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}