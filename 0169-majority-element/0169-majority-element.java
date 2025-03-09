class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int n= nums.length/2;
        int ans=-1;

        for(int ele:map.keySet()){
            if(map.get(ele)>n){
                ans=ele;
            }
        }
        return ans ;
    }
}