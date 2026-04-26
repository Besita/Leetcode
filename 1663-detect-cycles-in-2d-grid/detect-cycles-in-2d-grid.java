class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public boolean dfs(char[][] grid,int[][] vis,int row,int col,int prow,int pcol,int n,int m,char start){
            
        vis[row][col]=1;

        for(int i=0;i<4;i++){
            int x=row+dx[i];
            int y=col+dy[i];

            if(x<0 || y<0 || x>=n || y>=m )
                continue;

            if(grid[x][y]!=start)
                continue;

            if(x==row && y==col)
                continue;

            if(vis[x][y]==1){ 
                if(x!=prow || y!=pcol)
                    return true;
            }
            else{ 
                boolean curr=dfs(grid,vis,x,y,row,col,n,m,start);
                if(curr)
                    return true;
            }
            
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int [][]vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){ 
                vis[i][j]=0;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0){
                    if(dfs(grid,vis,i,j,-1,-1,n,m,grid[i][j]))
                        return true;
                }
            }
        }
        return false;
    }
}