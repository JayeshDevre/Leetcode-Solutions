class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
    int[] res = new int[k];
    int[] count = new int[20_000 + 1]; // due to the constraint -10^4 <= n <= 10^4
    int min = 10_000; // use this to make the lowest number -10^4 to 0 so we can count the frequency of those negative number
    for(int num : nums){
      count[num + min]++;
    }

    for(int i = 0; i < count.length;i++){
      if(count[i] == 0){
        continue;
      }

      pq.offer(new int[]{i, count[i]});
    }
    int i = 0;
    while(!pq.isEmpty() && i < k){
      res[i++] = pq.poll()[0] - min;
    }
    return res;
  }
}