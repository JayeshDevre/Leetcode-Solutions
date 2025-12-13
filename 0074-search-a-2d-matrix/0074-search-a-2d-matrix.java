class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int start=0;
        int end=m*n-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            int i=mid/m;
            int j=mid%m;

            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}