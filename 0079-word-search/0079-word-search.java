class Solution {

    private int m;
    private int n;
    private int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0) && find(0,i,j,board,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(int count, int i, int j, char[][] board, String word){
        if(count==word.length()){
            return true;
        }

        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='#'){
            return false;
        }

        if(board[i][j]!=word.charAt(count)){
            return false;
        }

        char temp=board[i][j];
        board[i][j]='#';

        for(int [] dir: directions){
            int i_=i+dir[0];
            int j_=j+dir[1];

            if(find(count+1, i_,j_,board, word)){
                return true;
            }
        }
        board[i][j]=temp;
        return false;

    }
}