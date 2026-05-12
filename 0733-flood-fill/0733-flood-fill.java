class Solution {
    int [][] directions= new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }

        int oldcolor=image[sr][sc];

        dfs(sr,sc,oldcolor,color,image);

        return image;

    }

    private void dfs(int sr, int sc, int oldcolor, int color, int[][] image){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=oldcolor){
            return;
        }

        image[sr][sc]=color;

        for(int [] d: directions){
            int nsr=sr+d[0];
            int nsc=sc+d[1];
            dfs(nsr,nsc,oldcolor,color,image);
        }
    }
}