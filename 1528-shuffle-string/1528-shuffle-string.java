class Solution {
    public String restoreString(String s, int[] indices) {
        char[] s2=new char[indices.length];
        for(int i=0;i<indices.length;i++){
            s2[indices[i]]=s.charAt(i);
        }

        return new String(s2);
    }
}