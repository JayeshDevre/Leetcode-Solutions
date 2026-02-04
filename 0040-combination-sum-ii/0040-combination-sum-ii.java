class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(result, new ArrayList<>(), target, candidates, 0);
        return result;
    }

    private void findCombinations(List<List<Integer>> result, List<Integer> temp, int target, int[] nums, int start){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }

            if(target-nums[i]<0){
                break;
            }

            temp.add(nums[i]);
            findCombinations(result, temp, target-nums[i], nums, i+1);
            temp.remove(temp.size()-1);
        }

    }
}