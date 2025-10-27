class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer,Integer> freq = new HashMap<>();
    for(int n:nums) freq.put(n,freq.getOrDefault(n,0)+1);
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
    for(var e: freq.entrySet()){
        pq.offer(new int[]{e.getKey(), e.getValue()});
        if(pq.size()>k) pq.poll();
    }
    int[] res = new int[pq.size()];
    int i=0; for(int[] a:pq) res[i++]=a[0];
    return res;
    }
}