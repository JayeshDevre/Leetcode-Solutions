class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        List<Integer>[] bucket= new ArrayList[nums.length+1];
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int key: map.keySet()){
            int frequency=map.get(key);
            if(bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int cnt=0;
        int [] ans= new int[k];

        for(int i=bucket.length-1;i>=0 && cnt<k;i--){
            if(bucket[i]!=null){
                for(int num: bucket[i]){
                    ans[cnt++]=num;
                }
            }
        }
        return ans;
    }
}