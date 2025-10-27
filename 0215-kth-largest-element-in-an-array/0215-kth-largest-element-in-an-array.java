class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
}