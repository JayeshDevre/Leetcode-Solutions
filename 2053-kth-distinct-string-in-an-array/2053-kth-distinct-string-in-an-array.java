class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String , Integer> map= new HashMap<>();

        for(String s: arr){
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }

        ArrayList<String> list= new ArrayList<>();
        for(String s: arr){
            if(map.get(s)==1){
                list.add(s);
            }
        }

        if (k > list.size()) {
            return ""; // Return empty string if k-th distinct does not exist
        }

        return list.get(k - 1); 
    }
}