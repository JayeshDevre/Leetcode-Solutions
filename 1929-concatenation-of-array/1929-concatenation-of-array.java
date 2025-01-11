class Solution {
    public int[] getConcatenation(int[] nums) {
        int arr[]=new int[nums.length*2];
        int size=nums.length*2;
        int add=0;
        for(int i=0;i<size;i++){
            if(i<size/2){
                arr[i]=nums[i];
            }else{
                arr[i]=nums[add];
                add++;
            }
            
        }
        return arr;
    }
}