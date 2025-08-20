class Solution {
    public void dfs(int row,int col,int n,int m,char[][] grid){
        if(grid[row][col]=='2' || grid[row][col]=='.')
            return;
        
        grid[row][col]='2';

        //if(row-1>=0)
          //  dfs(row-1,col,n,m,grid);
        //if(col-1>=0)
          //  dfs(row,col-1,n,m,grid);
        if(row+1<n)
            dfs(row+1,col,n,m,grid);
        if(col+1<m)
            dfs(row,col+1,n,m,grid);

    }
    public int countBattleships(char[][] board) {
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

}