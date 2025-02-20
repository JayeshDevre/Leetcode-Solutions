class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap< Character, Integer> map = new HashMap<>();

        char[] arr=s.toCharArray();

        for(char c: arr){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }  
        int l= map.get(arr[0]);
 
        for(char c: map.keySet()){
            if(map.get(c)!=l){
                return false;
               
            }
        }
        return true;
    }
}