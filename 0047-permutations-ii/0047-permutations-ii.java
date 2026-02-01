class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        boolean [] used= new boolean[nums.length];
        backTrack(result, new ArrayList<>(), nums,used);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[]used){

        if(temp.size()==nums.length && !result.contains(temp)){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length;i++){
            if(used[i]){
                continue;
            }

            used[i]=true;
            temp.add(nums[i]);

            backTrack(result, temp, nums, used);

            used[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}