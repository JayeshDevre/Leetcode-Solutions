class Solution {
    public int findDuplicate(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correct=arr[i];
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
        
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j){
                return arr[j];
            }
        }
        return -1;
    }
    
    void swap(int arr[],int start,int correct){
        int temp=arr[start];
        arr[start]=arr[correct];
        arr[correct]=temp;
    }
}