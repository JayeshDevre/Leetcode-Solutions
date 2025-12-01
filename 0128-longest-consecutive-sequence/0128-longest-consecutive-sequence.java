class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map= new HashMap<>();
        for(int i: nums){
            map.put(i,Boolean.FALSE);
        }
        int longestSequence=0;
        for(int i: nums){
            int currentSequence=1;
            int nextNum=i+1;

            while(map.containsKey(nextNum) && !map.get(nextNum)){
                currentSequence++;
                map.put(nextNum, Boolean.TRUE);
                nextNum++;
            }

            int prevNum=i-1;

            while(map.containsKey(prevNum) && !map.get(prevNum)){
                currentSequence++;
                map.put(prevNum, Boolean.TRUE);
                prevNum--;
            }

            longestSequence=Math.max(longestSequence,currentSequence);
        }
        return longestSequence;
    }
}