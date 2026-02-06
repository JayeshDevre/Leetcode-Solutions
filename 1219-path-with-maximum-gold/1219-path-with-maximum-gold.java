class Solution {
    private int[][] directions={{-1,0}, {1,0}, {0,1}, {0,-1}};
    public int getMaximumGold(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int maxGold=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                maxGold=Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }

        int currentGoldValue=grid[i][j];
        grid[i][j]=0;
        int maxGold=0;

        for(int [] dir: directions){
            int i_=i+dir[0];
            int j_=j+dir[1];
            maxGold=Math.max(maxGold, dfs(grid, i_, j_));
        }
        grid[i][j]=currentGoldValue;
        return currentGoldValue+maxGold;
    }
}