class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int max=0;
        int count=0;
        for(int i: map.values()){
            max=Math.max(max,i);
        }
      
       for(int j: map.values()){
        if(j==max){
            count++;
        }
    }
    return max*count;
}}