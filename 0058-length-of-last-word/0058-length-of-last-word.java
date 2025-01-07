class Solution {
    public int lengthOfLastWord(String s) {
        s.trim();
        String [] str=s.split(" ");
        String ans=str[str.length-1];
        return ans.length();

    }
}