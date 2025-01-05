class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while(i<nums.length){
            int ci=nums[i]-1;
            if(nums[i]!=nums[ci]){
                swap(nums,i,ci);
            }else{
                i++;
            }
        }
        List <Integer> l=new ArrayList<>();

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                l.add(nums[j]);
            }
        }

        return l;
    }

      public static void swap(int arr[], int first, int second ){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}