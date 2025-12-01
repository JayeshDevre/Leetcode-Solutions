class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int longestSequence=0;
        for(int num: set){
            if(!set.contains(num-1)){
                int currentSequence=1;
                int nextNum=num+1;
                while(set.contains(nextNum)){
                    currentSequence++;
                    nextNum++;
                }
               longestSequence= Math.max(longestSequence,currentSequence); 
            }
        }
        return longestSequence;
    }
}