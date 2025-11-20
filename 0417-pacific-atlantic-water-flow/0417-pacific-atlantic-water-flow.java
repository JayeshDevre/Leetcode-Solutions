class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result=new ArrayList<>();
        if(heights.length==0 || heights[0].length==0){
            return result;
        }

        int row=heights.length;
        int col=heights[0].length;
        boolean[][] pacific=new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];

        for(int i=0;i<row;i++){
            dfs(i,0,pacific,heights);
            dfs(i,col-1,atlantic,heights);
        }

        for(int i=0;i<col;i++){
            dfs(0,i,pacific,heights);
            dfs(row-1,i,atlantic,heights);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] rechable, int[][] heights){
        int[][] directions= new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        rechable[row][col]=true;
        for(int [] dir:directions){
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            if(newRow<0 || newRow>=heights.length || newCol<0 || newCol>=heights[0].length){
                continue;
            }
            if(rechable[newRow][newCol]){
                continue;
            }

            if(heights[newRow][newCol]>=heights[row][col]){
                dfs(newRow,newCol,rechable,heights);
            }
        }
    }
}