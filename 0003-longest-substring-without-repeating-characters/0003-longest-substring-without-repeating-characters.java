class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0;
        int left=0;
        int n=s.length();
        HashSet<Character> set= new HashSet<>();
        for(int right=0;right<n;right++){
            char c= s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            maxlen=Math.max(maxlen, right-left+1);
            set.add(c);
        }
        return maxlen;
    }
}