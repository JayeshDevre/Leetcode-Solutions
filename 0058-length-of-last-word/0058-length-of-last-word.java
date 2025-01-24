class Solution {
    public int lengthOfLastWord(String s) {
        // for(int i=s.length-1;i>=0;i--){
        //     a=a+a.charAt(i);
        // }
        String[] a=s.split(" ");
        return a[a.length-1].length();
    }
}