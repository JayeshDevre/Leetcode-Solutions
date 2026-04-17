class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map= new HashMap<>();


        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int p=0;
        for(int i=0;i<3;i++){
            int freq=map.getOrDefault(i,0);
            for(int j=0;j<freq;j++){
                nums[p]=i;
                p++;
            }
        }

    }
}