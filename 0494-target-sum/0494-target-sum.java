class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> map= new HashMap<>();
        return helper(0,0,nums,target, map);
    }

    private int helper(int index, int currSum, int [] nums, int target,HashMap<String, Integer> map){
        if(index==nums.length){
            if(currSum==target) return 1;
            return 0;
        }

        String key= index+"_"+currSum;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int plus=helper(index+1, currSum+nums[index], nums, target, map);
        int minus=helper(index+1, currSum-nums[index], nums, target, map);
        map.put(key,plus+minus);
        return plus+minus;

    }
}