class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> map= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            map.add(nums[i]);
        }
        List<Integer> list= new ArrayList<>();

        Arrays.sort(nums);
        int low=nums[0];
        int high=nums[nums.length-1];

        for(int i=low;i<=high;i++){
            if(!map.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}