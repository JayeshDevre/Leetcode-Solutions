class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, target, candidates,result, new ArrayList<>());
        return result;
    }

    private void findCombinations(int index, int target, int[] nums, List<List<Integer>> result, List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            if(target-nums[i]<0){
                break;
            }
            temp.add(nums[i]);
            findCombinations(i+1, target-nums[i], nums, result, temp);
            temp.remove(temp.size()-1);
        }
    }
}