class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        findCombinations(0,target, candidates,result, new ArrayList<>());
        return result;
    }

    private void findCombinations(int ind, int target, int [] nums, List<List<Integer>> result, List<Integer> temp ){
        if(nums.length==ind){
            return;
        }

        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(nums[ind] <= target){
            temp.add(nums[ind]);
            findCombinations(ind, target-nums[ind], nums, result, temp);
            temp.remove(temp.size()-1);
        }
        findCombinations(ind+1,target, nums, result, temp);

    }
}