class Solution {

    private boolean noZero(int x){
         while(x>0){
            if(x%10==0){
                return false;
            }
            x=x/10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {
    
        for(int i=1;i<n;i++){
            int a=i;
            int b=n-i;
            if(noZero(a)&& noZero(b)){
                return new int[]{a,b};
            }
        }
        return new int[0];
    }
}