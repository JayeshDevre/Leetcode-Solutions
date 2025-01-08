class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s);
        String arr[]=s.split(" ");
        String s2="";
        for(int i=arr.length-1;i>=0;i--){
            s2=s2+arr[i]+" ";
        }
        s2=s2.replaceAll("\\s+", " ").trim();
        return s2;
    }
}