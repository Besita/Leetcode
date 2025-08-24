class Solution {
    
    public void dfs(int row,int col,int m,int n,char[][] board,int[][] vis){
        if(row<0 || col<0 || row>=m || col>=n || vis[row][col]==1 || board[row][col]=='X' )
            return;
        vis[row][col]=1;
        board[row][col]='B';

        //System.out.println(row+" "+col);
        //if(row-1>=0)
            dfs(row-1,col,m,n,board,vis);
        //if(row+1<m)
            dfs(row+1,col,m,n,board,vis);
        //if(col+1<n)
            dfs(row,col+1,m,n,board,vis);
        //if(col-1>=0)
            dfs(row,col-1,m,n,board,vis);       

    }
   
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(vis[i],0);

        for(int j=0;j<n;j++){ //top bottom
            if(board[0][j]=='O' && vis[0][j]==0)
                dfs(0,j,m,n,board,vis);

            if(board[m-1][j]=='O' && vis[m-1][j]==0)
                dfs(m-1,j,m,n,board,vis);
        }

        for(int i=0;i<m;i++){ //left right
            if(board[i][0]=='O' && vis[i][0]==0)
                dfs(i,0,m,n,board,vis);

            if(board[i][n-1]=='O' && vis[i][n-1]==0)
                dfs(i,n-1,m,n,board,vis);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==0)
                    board[i][j]='X';           
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){ 
                 if(board[i][j]=='B')
                    board[i][j]='O'; 
            }
        }
    }
}