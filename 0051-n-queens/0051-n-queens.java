class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result= new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        backTrack(0, board, result);
        return result;
    }

    private void backTrack(int col, char[][] board, List<List<String>> result){
        int n = board.length;
        if(col==n){
            result.add(construct(board));
            return;
        }

        for(int row=0;row<n;row++){
            if(isValid(row,col,board)){
                board[row][col]='Q';
                backTrack(col+1,board, result);
                board[row][col]='.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] board){
        int n=board.length;
        
        for(int j=0;j<col;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }

        for(int i=row , j=col; i>=0 && j>=0 ; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row,j=col ; i<n && j>=0 ; i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] board){
        List<String> result= new ArrayList<>();
        for(char[] row: board){
            result.add(new String(row));
        }
        return result;
    }
}