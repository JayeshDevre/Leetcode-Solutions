class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();

        for(int num: arr ){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int n: map.keySet()){
            set.add(map.get(n));
        }

        if(set.size()==map.size()){
            return true;
        }
        return false;


    }
}