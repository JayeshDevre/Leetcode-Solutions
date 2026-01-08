class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    int n;
    public int swimInWater(int[][] grid) {
        n=grid.length;
        int start=grid[0][0];
        int end=n*n-1;
        int result=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            boolean[][] visited=new boolean[n][n];
            if(possibleToReach(grid,0,0,mid,visited)){
                result=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return result;
    }

    private boolean possibleToReach(int[][] grid, int i,int j, int time, boolean[][] visited){
        if(i<0 || i>n-1 || j<0 || j>n-1 || visited[i][j]==true || grid[i][j]> time){
            return false;
        }

        visited[i][j]=true;

        if(i==n-1 && j==n-1){
            return true;
        }

        for(int [] dir: directions){
            int u=i+dir[0];
            int v=j+dir[1];

            if(possibleToReach(grid,u,v,time,visited)){
                return true;
            }
        }
        return false;
    } 
}