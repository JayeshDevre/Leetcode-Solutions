class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }

        int row=grid.length;
        int col=grid[0].length;
        int time[][]=new int[row][col];
// create and fill the duplicate array with max value
        for(int i=0;i<row;i++){
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }
// pass to dfs if you find value 2
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    dfs(grid,time,i,j,0);
                }
            }
        }
        int days=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                if(time[i][j]==Integer.MAX_VALUE){
                    return -1;
                }
                days=Math.max(time[i][j],days);
                }
            }
        }
        return days;
    }

    private void dfs(int grid[][], int time[][], int i, int j, int currentTime){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || currentTime>=time[i][j]){
            return;
        }
        time[i][j]=currentTime;
        dfs(grid,time,i+1,j,currentTime+1);
        dfs(grid,time,i-1,j,currentTime+1);
        dfs(grid,time,i,j+1,currentTime+1);
        dfs(grid,time,i,j-1,currentTime+1);
    }
}