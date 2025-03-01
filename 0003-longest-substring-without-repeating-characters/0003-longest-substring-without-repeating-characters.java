class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        char[] s1=s.toCharArray();
        for(int i=0;i<s1.length;i++){

           int[] hash = new int[256];
            for(int j=i;j<s1.length;j++){
                if(hash[s1[j]]==1){
                    break;
                }
                hash[s1[j]] = 1;
                int length=j-i+1;
                max=Math.max(max,length);

            }
        }
        return max;
    }
}