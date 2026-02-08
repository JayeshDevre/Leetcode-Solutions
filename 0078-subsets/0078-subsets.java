class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        backTrack(0, result, new ArrayList<>(), nums);
        return result;
    }

    private void backTrack(int index, List<List<Integer>> result, ArrayList<Integer> temp, int [] nums){

        result.add(new ArrayList<>(temp));

        for(int i=index; i<nums.length;i++){
            temp.add(nums[i]);
            backTrack(i+1, result, temp, nums);
            temp.remove(temp.size()-1);
        }



    }
}