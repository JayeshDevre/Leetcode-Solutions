class Solution {
    public void solve(char[][] board) {
        if(board==null || board[0].length==0){
            return;
        }
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || i==row-1 || j==0 || j==col-1 && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
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

    private void dfs(char [][] board, int row, int col){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!='O'){
            return;
        }
        board[row][col]='T';
        dfs(board,row-1,col);
        dfs(board,row+1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
    }
}