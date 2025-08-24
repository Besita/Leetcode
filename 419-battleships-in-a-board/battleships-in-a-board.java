class Solution {
    public void dfs(int row,int col,int n,int m,char[][] grid){
        if(grid[row][col]=='2' || grid[row][col]=='.')
            return;
        
        grid[row][col]='2';

        if(row+1<n)
            dfs(row+1,col,n,m,grid);
        if(col+1<m)
            dfs(row,col+1,n,m,grid);

    }
    public int method1(char[][] board){
        int n=board.length;
        int m=board[0].length;
        int battleships=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X'){ 
                    battleships++;
                    dfs(i,j,n,m,board);
                }
            }
        }
        return battleships;
    }
   // board[i][j]=='X' && (i==n-1 || board[i+1][j]=='.') 
     ///               && (j==m-1 || board[i][j+1]=='.'))
    public int method2(char[][] board){
        int n=board.length;
        int m=board[0].length;
        int battleships=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X' 
                    && ((i+1<n && board[i+1][j]=='.') || i==n-1)
                    && ((j+1<m && board[i][j+1]=='.') || j==m-1))
                        battleships++;
            }        
        }
        return battleships;
    }
    public int countBattleships(char[][] board) {      

        //return method1(board); //updating board and dfs
        return method2(board); //no updated board and one pass
        
    }

}