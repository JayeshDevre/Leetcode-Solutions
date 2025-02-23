class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();

        HashMap<String, List<String>> map=new HashMap<>();

        for(String str: strs){
            char [] arr= str.toCharArray();
            Arrays.sort(arr);
            String key= new String(arr);

            if(map.containsKey(key)){
               map.get(key).add(str);
            }else{
                List <String> l1= new ArrayList<>();
                l1.add(str);
                map.put(key, l1);
            }
        }
        ans.addAll(map.values());
        return ans;
    }
}