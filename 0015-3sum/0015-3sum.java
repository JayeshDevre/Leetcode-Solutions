class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        // HashSet<List<Integer>> set=new HashSet<>();
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer>t= Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(t);
        //                 set.add(t);
        //             }
        //         }
        //     }
        // }
     
        // return new ArrayList<>(set);

        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int j=i+1;
            int k=n-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    l.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                } else if(sum<0){
                    j++;
                }else{
                    k--;
                }

                // if()

            }

        }
        return l;
    }
}