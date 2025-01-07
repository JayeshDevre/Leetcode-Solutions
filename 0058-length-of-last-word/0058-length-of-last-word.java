class Solution {
    public int lengthOfLastWord(String s) {
        String n=s.trim();
        String[] ar=n.split(" ");
        String word="";
        // for(int i=ar.length-1;i<=0;i--){
            word=ar[ar.length-1];
        // }
        int len=word.length();
        return len;
    }
}