class Solution {
    public String reversePrefix(String word, char ch) {
       int firstOcc=word.indexOf(ch);
       StringBuilder sb=new StringBuilder(word.substring(0,firstOcc+1)).reverse();
       sb.append(word.substring(firstOcc+1));
       return sb.toString();
    }
}