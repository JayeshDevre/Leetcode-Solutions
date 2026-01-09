class Solution {
    public boolean isValidSudoku(char[][] board) {
       int n=9;
       for (int i=0;i<n;i++){
        HashSet<Character> set= new HashSet<>();
        for(int j=0;j<n;j++){
            if(board[i][j]=='.'){
                continue;
            }
            if(!set.add(board[i][j])){
                return false;
            }
        }
       } 
        for (int j=0;j<n;j++){
        HashSet<Character> set= new HashSet<>();
        for(int i=0;i<n;i++){
            if(board[i][j]=='.'){
                continue;
            }
            if(!set.add(board[i][j])){
                return false;
            }
        }
       }

       for(int boxRow=0;boxRow<9;boxRow+=3){
        for(int boxCol=0;boxCol<9;boxCol+=3){
            HashSet<Character> set= new HashSet<>();
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    int row=i+boxRow;
                    int col=j+boxCol;
                    if(board[row][col]=='.'){
                        continue;
                    }
                    if(!set.add(board[row][col])){
                        return false;
                    }
                }
            }
        }
       }
        return true;
    }
}