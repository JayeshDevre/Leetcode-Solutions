class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Define MaxHeap
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<points.length;i++){
            int [] point=points[i];
            int x=point[0];
            int y=point[1];

            int dist=(x*x)+(y*y);

            maxHeap.add(new int[]{dist,i});

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int [][] res=new int[k][2];

        int i=0;
        while(i<k){
            int [] r=maxHeap.poll();
            int coord=r[1];

            res[i][0]=points[coord][0];
            res[i][1]=points[coord][1];
            i++;
        }
        return res;
    }
}