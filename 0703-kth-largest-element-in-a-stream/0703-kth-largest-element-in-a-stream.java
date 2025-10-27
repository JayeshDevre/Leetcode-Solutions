class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minHeap=new PriorityQueue<Integer>();

        for(int i : nums){
            minHeap.add(i);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.add(val);
            return minHeap.peek();
        }
        minHeap.add(val);
        minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */