class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List <Integer> [] bucket = new List[nums.length+1];

        HashMap <Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }


        for(int key: map.keySet()){
            int frequency= map.get(key);
            if(bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int [] result=new int[k];
        int count=0;

        for(int i=bucket.length-1;i>=0&& count<k;i--){

            if(bucket[i]!=null){
                for(int j: bucket[i]){
                    result[count]=j;
                    count++;
                }
            }
        }
        return result;

    }
}