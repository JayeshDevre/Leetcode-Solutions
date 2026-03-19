class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;

        Integer [] queryIndex = new Integer[n];
        int [] result = new int[n];

        for(int i=0;i<n;i++){
            queryIndex[i]=i;
        }

        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(queryIndex, (a,b)->Integer.compare(queries[a],queries[b]));

        PriorityQueue<int []> pq= new PriorityQueue<>(Comparator.comparingInt(a->a[1]-a[0]));

        int intervalIndex=0;

        for(int i=0;i<n;i++){
            int query=queries[queryIndex[i]];

            while(intervalIndex<intervals.length && query >= intervals[intervalIndex][0]){
                int left= intervals[intervalIndex][0];
                int right= intervals[intervalIndex][1];

                if(right>=query){
                    pq.offer(new int[]{left, right});
                }
                intervalIndex++;
            }

            while(!pq.isEmpty() && pq.peek()[1]<query){
                pq.poll();
            }

            if(pq.isEmpty()){
                result[queryIndex[i]]=-1;
            }else{
                int[] smallInterval = pq.peek();
                result[queryIndex[i]]=smallInterval[1]-smallInterval[0]+1;
            }
        }
        return result;
    }
}