class Solution {
    private int [][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans= new int [n][m];
        for(int [] arr: ans){
            Arrays.fill(arr,-1);
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    queue.add(new int[]{i,j});
                }else{
                    ans[i][j]=-1;
                }
            }
        }

        while(!queue.isEmpty()){
            int [] cell=queue.poll();
            int i=cell[0];
            int j=cell[1];

            for(int [] dir : directions){
                int i_= i + dir[0];
                int j_= j + dir[1];

                if(i_>= 0 && i_ <n && j_ >= 0 && j_ < m && ans[i_][j_]==-1){
                    ans[i_][j_]=ans[i][j]+1;
                    queue.add(new int[]{i_,j_});
                }
            }

        }

        return ans;
    }
}