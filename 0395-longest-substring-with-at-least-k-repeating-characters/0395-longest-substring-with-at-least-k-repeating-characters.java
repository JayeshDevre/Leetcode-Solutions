class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length()<k || s.length()==0){
            return 0;
        }

        // a:3
        // b:2

        HashMap<Character, Integer> map= new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))<k){
                int left = longestSubstring( s.substring(0,i), k);
                int right = longestSubstring(s.substring(i+1),k);
                return Math.max(left,right);
            }
        }
        return s.length();
    }
}