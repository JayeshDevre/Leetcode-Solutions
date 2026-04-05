class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> set= new HashSet<>();
        int maxLen=0;
        int left=0;

        for(int right=0;right<n;right++){
            char c=s.charAt(right);

            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

            maxLen=Math.max(maxLen, right-left+1);
            set.add(c);

        }
        return maxLen;
    }
}