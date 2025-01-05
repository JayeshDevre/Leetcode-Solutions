class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> l= new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swap(nums,i,correctIndex);
            }else{
                i++;
            }
        }

        for(int index=0;index<nums.length;index++){
            if(nums[index]!=index+1){
                l.add(index+1);
            }
        }
        return l;
    }

    public void swap(int arr[], int f,int l){
        int temp=arr[f];
        arr[f]=arr[l];
        arr[l]=temp;
    }
}