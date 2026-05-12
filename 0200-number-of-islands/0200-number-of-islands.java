class Solution {
    private int[][] directions= new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, char[][] grid){
        if(i<0 ||i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0';

        for(int [] d: directions){
            int i_=i+d[0];
            int j_=j+d[1];
            dfs(i_,j_,grid);
        }
    }
}