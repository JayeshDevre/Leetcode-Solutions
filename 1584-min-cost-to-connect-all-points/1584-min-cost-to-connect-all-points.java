class Solution {
    static class Point{
        int index;
        int distance;

        Point(int index, int distance){
            this.index=index;
            this.distance=distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Point> pq= new PriorityQueue<>((a,b)-> a.distance - b.distance);
        boolean [] inMst= new boolean [n];
        pq.offer(new Point(0,0));
        int minCost=0;
        int numberOfNodes=0;

        while(numberOfNodes<n){
            Point current=pq.poll();
            int node= current.index;
            int d=current.distance;
            if(inMst[node]){
                continue;
            }
            inMst[node]=true;
            numberOfNodes++;
            minCost+=d;
            for(int i=0;i<n;i++){
                if(!inMst[i]){
                    int distance=Math.abs(points[node][0]-points[i][0]) + Math.abs(points[node][1]-points[i][1]);
                    pq.offer(new Point(i,distance));
                }
            }
        }
        return minCost;
    }
}