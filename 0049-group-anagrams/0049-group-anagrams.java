class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        HashMap< String, List<String>> map=new HashMap<>();

        for(String s: strs){
            char arr[] =s.toCharArray();
            Arrays.sort(arr);
            String s1=new String(arr);
         List <String> l1= new ArrayList<>();
            if(map.containsKey(s1)){
                map.get(s1).add(s);
            }else{
                
                l1.add(s);
                map.put(s1,l1);
            }
        }

      
        list.addAll(map.values());
        
        return list; 
    }
}