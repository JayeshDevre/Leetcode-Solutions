class Solution {
    int [][] directions= new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int orangesRotting(int[][] grid) {
        int ans=0;

        int m=grid.length;
        int n=grid[0].length;

        int arr[][] = new int[m][n];

        for(int [] a:arr){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    dfs(i,j,grid,arr,0);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(arr[i][j]==Integer.MAX_VALUE){
                        return -1;
                    }

                    ans=Math.max(ans, arr[i][j]);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] grid, int [][] ans, int ct){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || ct>=ans[i][j]){
            return;
        }

        ans[i][j]=ct;
        for(int [] dir:directions){
            int i_=i+dir[0];
            int j_=j+dir[1];
            dfs(i_,j_,grid,ans,ct+1);
        }
    }
}