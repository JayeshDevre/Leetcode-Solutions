import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
       int left=0;
       int right=nums.length-1;

    //    while(left<right){
    //     int sum=nums[left]+nums[right];
    //     if(sum==target){
    //         return new int[]{left,right};
    //     }
    //     else if(sum<target){
    //         left=left+1;
    //     }else{
    //         right=right-1;
    //     }
    //    }

    //    return new int[]{};

    HashMap< Integer, Integer> map= new HashMap<>();
    for(int i=0;i<nums.length;i++){
        int comp= target- nums[i];
        if(map.containsKey(comp)){
            return new int[]{map.get(comp), i};
        }
        else{
            map.put(nums[i],i);
        }
    }
    return new int[]{};
    }
}
