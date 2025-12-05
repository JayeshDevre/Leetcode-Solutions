class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> map= new HashSet<>();
        List<Integer> list= new ArrayList<>();
        int low= Integer.MAX_VALUE;
        int high= Integer.MIN_VALUE;

        for(int num: nums){
            map.add(num);
            low=Math.min(num,low);
            high=Math.max(num,high);
        }

        for(int i=low;i<=high;i++){
            if(!map.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}