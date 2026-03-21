class Solution {
    public void rotate(int[][] matrix) {
        int m= matrix.length;
        int n=m;

        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){
                int temp= matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<m;i++){
            reverseArray(matrix[i]);
        }
    }

    private void reverseArray(int [] arr){
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}