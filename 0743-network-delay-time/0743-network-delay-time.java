class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map= new HashMap<>();
        for(int[] time: times){
            map.computeIfAbsent(time[0],x->new ArrayList<>()).add(new int[] {time[1],time[2]});
        } 

        PriorityQueue<int[]> pq= new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[]{k,0});

        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        boolean[] visited= new boolean[n+1];

        while(!pq.isEmpty()){
            int[] current= pq.poll();
            int currentnode=current[0];
            int currentdistance=current[1];

            if(visited[currentnode]) continue;
            visited[currentnode]=true;

            if(map.containsKey(currentnode)){
                for(int [] nei: map.get(currentnode)){
                    int nextNode=nei[0];
                    int nextDist=currentdistance+nei[1];
                    if(nextDist<dist[nextNode]){
                        dist[nextNode]=nextDist;
                        pq.offer(new int[] {nextNode,nextDist} );
                    }
                }
            }
        }
            int ans=0;

            for(int i=1;i<=n;i++){
                if(dist[i]==Integer.MAX_VALUE) return -1;
                ans= Math.max(dist[i],ans);
            }
            return ans;
    }
}