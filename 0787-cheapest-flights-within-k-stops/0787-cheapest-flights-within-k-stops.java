class Solution {

    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }

    class Tuple{
        int first;
        int second;
        int third;
        Tuple(int f,int s,int t){
            this.first=f;
            this.second=s;
            this.third=t;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        int m=flights.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> queue= new LinkedList<>();
        queue.offer(new Tuple(0,src,0));

        int [] dist= new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;

        while(!queue.isEmpty()){
            Tuple t=queue.poll();
            int stops=t.first;
            int node=t.second;
            int cost=t.third;

            if(stops>k){
                continue;
            }

            for(Pair p: adj.get(node)){
                int wt= p.second;
                if(cost+wt<dist[p.first] && stops<=k){
                    dist[p.first]=cost+wt;
                    queue.add(new Tuple(stops+1,p.first,cost+wt));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
    return dist[dst];
    }
}