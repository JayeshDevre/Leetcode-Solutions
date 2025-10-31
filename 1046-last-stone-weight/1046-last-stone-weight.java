class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int num:stones){
            pq.add(num);
        }

        while(!pq.isEmpty()){
            int y=pq.poll();

            if(pq.isEmpty()){
                return y;
            }

            int x=pq.poll();

            if(x!=y){
                int n=y-x;
                pq.add(n);
            }
        }
        return 0;
    }
}
