class Solution {
    public int countElements(int[] nums, int k) {
        int n= nums.length;
        Arrays.sort(nums);
        if(k==0){
            return n;
        }

        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        int count=0;
        for(int i=0;i<n;i++){
            int last=map.get(nums[i]);
            int greater= (n-1)-last;
            if(greater>=k){
                count++;
            }
        }
        return count;

    }
}