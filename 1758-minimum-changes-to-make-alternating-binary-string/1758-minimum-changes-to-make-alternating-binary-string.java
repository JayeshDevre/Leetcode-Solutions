class Solution {
    public int minOperations(String s) {
        int count1=0;
        int count2=0;

        for(int i=0;i<s.length();i++){
            char ch1=(i%2==0)?'0':'1';   //0101
            char ch2=(i%2==0)?'1':'0';   //1010

            if(ch1!=s.charAt(i)){
                count1++;
            }

            if(ch2!=s.charAt(i)){
                count2++;
            } 
        }
        return Math.min(count1,count2);

    }
}