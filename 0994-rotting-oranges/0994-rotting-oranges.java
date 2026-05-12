class Solution {
    private int [][] directions= new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> queue= new LinkedList<>();
        int fresh=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int minutes=0;

        while(!queue.isEmpty() && fresh>0){
            int size=queue.size();

            for(int k=0;k<size;k++){
                int [] cell=queue.poll();
                for(int [] d:directions){
                    int x=cell[0]+d[0];
                    int y=cell[1]+d[1];

                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        queue.add(new int[]{x,y});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}