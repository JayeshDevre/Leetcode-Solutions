class Solution {
    public int characterReplacement(String s, int k) {
       HashMap<Character, Integer> map= new HashMap<>();
       int maxF=0;
       int ans=0;
       int left=0;
       

       for(int right=0;right<s.length();right++){
        char c=s.charAt(right);
        map.put(c, map.getOrDefault(c,0)+1);
        maxF = Math.max(maxF, map.get(c));

        if((right-left+1) - maxF > k ){
            map.put(s.charAt(left), map.get(s.charAt(left))-1);
            left++;
        }
        ans=Math.max(ans, right-left+1);
       }
       return ans;
    }
}