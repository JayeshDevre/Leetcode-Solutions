class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return;
        }

        int row=board.length;
        int col=board[0].length;

        for(int i=0;i<row;i++){
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][col-1]=='O') dfs(board,i,col-1);
        }

        for(int i=0;i<col;i++){
            if(board[0][i]=='O') dfs(board,0,i);
            if(board[row-1][i]=='O') dfs(board,row-1,i);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i,int j){
        board[i][j]='T';

        int [][]dirs=new int [][]{{1,0},{-1,0},{0,1},{0,-1}};

        for(int [] dir: dirs){
            int newRow=i+dir[0];
            int newCol=j+dir[1];

            if(newRow<0 || newRow>=board.length || newCol<0 || newCol>=board[0].length){
                continue;
            }

            if(board[newRow][newCol]!='O'){
                continue;
            }

            dfs(board,newRow,newCol);
        }
    }
}