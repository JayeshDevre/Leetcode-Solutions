class Solution {
    public boolean isPalindrome(int x) {
//         int num1=x;
//         int num2=0;
//         while(num1!=0){
//             int lastnum=num1%10;
//             num2=num2*10+lastnum;
//             num1=num1/10;
//         }
        
//         if(x==num2){
//             return true;
//         }else{
//             return false;
//         }
        String s1=String.valueOf(x);
        String s2="";
       for(int i=0;i<s1.length();i++){
           char c=s1.charAt(i);
           s2=c+s2;
       }
        if(s1.equals(s2)){
            return true;
        }else{
            return false;
        }
    }
}