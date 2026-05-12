class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return -1;
        }

        int[][] directions= new int[][] {{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};

        Queue<int[]> queue= new LinkedList<>();
        // [0,0,1] [position , steps];
        queue.add(new int[]{0,0,1});
        grid[0][0]=1;

        while(!queue.isEmpty()){
            int cell[] =queue.poll();
            int i=cell[0];
            int j=cell[1];
            int steps=cell[2];

            if(i==m-1 && j==n-1){
                return steps;
            }

            for(int d[]: directions){
                int i_=i+d[0];
                int j_=j+d[1];

                if(i_>=0 && i_<m && j_>=0 && j_<n && grid[i_][j_]==0){
                    grid[i_][j_]=1;
                    queue.add(new int[]{i_,j_,steps+1});
                }
            }
        }
        return -1;
    }
}