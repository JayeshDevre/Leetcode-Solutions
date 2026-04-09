class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0;
        int ans=0;
        int maxf=0;

        for(int right=0; right<s.length(); right++){
            char c= s.charAt(right);
            map.put(c, map.getOrDefault(c,0)+1);
            maxf= Math.max(maxf, map.get(c));

            if((right-left+1)-maxf > k){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)-1);
                left++;
            }

            ans=Math.max(ans, right-left+1);
        }
        return ans;
    }
}