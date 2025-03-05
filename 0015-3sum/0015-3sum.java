class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer>t= Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(t);
                        set.add(t);
                    }
                }
            }
        }
     
        return new ArrayList<>(set);
    }
}