package oct2021;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m =board.length;
        int n=board[0].length;
        for(int i= 0; i < m; i++){
            for( int j =0; j < n; j++ ){
                if(board[i][j] == word.charAt(0) && dfs( i, j, 0, board, word )){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean  dfs(int i,int j, int index, char[][] board,String word){
        if( index == word.length())
            return true;
        if(i < 0 || j < 0 || i >= board.length || j  >= board[0].length || board[i][j]!=word.charAt(index) )
            return false;
        char temp= board[i][j];
        board[i][j]=' ';
        boolean found= dfs( i+1, j, index+1,board,word) || dfs(i ,j+1,index+1,board,word) ||  dfs( i-1, j, index+1,board,word) || dfs(i ,j-1,index+1,board,word);
        board[i][j]=temp;
        return found;
    }

}
