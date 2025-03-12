class Solution {
    public int search(int[] nums, int target) {
int ans=binarySearch(nums,target,0,nums.length-1);
return ans;
    }

    public int binarySearch(int [] nums, int target, int start, int end){
        if(start>end){
             return -1;
        }

        int mid=start+(end-start)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>=nums[start]){
            if(target>=nums[start] && target<nums[mid] ){
                return binarySearch(nums,target,start,mid-1);
            }else{
                return binarySearch(nums,target,mid+1,end);
            }
        }else{
            if( target>nums[mid] && target<=nums[end]){
                return binarySearch(nums,target,mid+1,end);
            }else{
                return binarySearch(nums,target,start,mid-1);
            }
        }
}
}