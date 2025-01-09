class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int ans=bsearch(nums,target,start,end);
        return ans;
    }

    public int bsearch(int arr[], int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
            return bsearch(arr,target,start,mid-1);
        }
        return bsearch(arr,target,mid+1,end);
    }
}