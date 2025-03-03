class Solution {
    int happyN(int n){
         int sum=0;
         while(n!=0){
            int lastnum=n%10;
            sum=sum+lastnum*lastnum;
            n=n/10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        int result=n;
      while(result!=1 && result !=4){
          result=happyN(result);
      }
        if(result==1){
            return true;
        }else{
            return false;
        }
    }
}