class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxlen=0;
        for(int i=0;i<n;i++){
            boolean [] seen = new boolean[256];
            for(int j=i; j<n;j++){
                char c=s.charAt(j);
                if(seen[c]==true){
                    break;
                }
                maxlen=Math.max(maxlen,j-i+1);
                seen[c]=true;
            }
        }
        return maxlen;
    }
}