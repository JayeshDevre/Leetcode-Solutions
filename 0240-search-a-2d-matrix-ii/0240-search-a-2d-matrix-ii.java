class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(bs(matrix[i],target)!=-1){
                return true;
            }
        }
        return false;
    }

    private int bs(int[] matrix, int target){
        int start=0;
        int end=matrix.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(matrix[mid]==target){
                return mid;
            }else if(matrix[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}