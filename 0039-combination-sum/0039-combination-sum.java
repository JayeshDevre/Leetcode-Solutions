class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        findCombinations(0, target, candidates,result, new ArrayList<>());
        return result;
    }

    private void findCombinations(int index, int target, int[] nums, List<List<Integer>> result, List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(target<0){
            return;
        }

        for(int i=index; i<nums.length;i++){
            temp.add(nums[i]);
            findCombinations(i, target-nums[i], nums, result, temp);
            temp.remove(temp.size()-1);
        }
    }
}