class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxAns=-1;
        int maxFreq=-1;

        for(int i:map.keySet()){
            if(i%2==0){
                int freq=map.get(i);
                if(freq>maxFreq || (maxFreq==freq && i<maxAns) ){
                    maxFreq=freq;
                    maxAns=i;
                }
            }
        }
        return maxAns;
    }
}