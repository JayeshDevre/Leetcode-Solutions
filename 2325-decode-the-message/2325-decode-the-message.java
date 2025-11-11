class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map=new HashMap<>();
        char currentCh='a';
// Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
// Output: "this is a secret"

        for(char ch:key.toCharArray()){
            if(ch!=' ' && !map.containsKey(ch)){
                map.put(ch,currentCh++);
            }
        }

        StringBuilder decoded=new StringBuilder();
        for(char ch: message.toCharArray()){
            if(ch==' '){
                decoded.append(' ');
            }else{
                decoded.append(map.get(ch));
            }
        }
        return decoded.toString();


    }
}