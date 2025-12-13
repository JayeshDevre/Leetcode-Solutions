class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            int start=matrix[i][0];
            int end=matrix[i][n-1];
            if(start<=target && target<=end){
                return bs(matrix[i],target);
            }
        }
        return false;
    }

    private boolean bs(int[] matrix, int target){
        int low=0;
        int high=matrix.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(matrix[mid]==target){
                return true;
            }else if(matrix[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}