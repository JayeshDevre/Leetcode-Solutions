class Solution {
    public boolean isPowerOfFour(int n) {
       for(int i=0;i<31;i++){
        if(n==Math.pow(4,i)){
            return true;
        }
       }
       return false;
    }
}