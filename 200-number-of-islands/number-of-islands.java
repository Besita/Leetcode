class Solution {
    public void dfs(int row,int col,int n,int m,int[][] vis,char[][] grid){
        if(vis[row][col]==1 || grid[row][col]=='0')
            return;
        
        vis[row][col]=1;

        if(row-1>=0)
            dfs(row-1,col,n,m,vis,grid);
        if(col-1>=0)
            dfs(row,col-1,n,m,vis,grid);
        if(row+1<n)
            dfs(row+1,col,n,m,vis,grid);
        if(col+1<m)
            dfs(row,col+1,n,m,vis,grid);

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(vis[i],0);

        int islandCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){ 
                    System.out.println(grid[i][j]+" "+vis[i][j]);
                    islandCount++;
                    dfs(i,j,n,m,vis,grid);
                }
            }
        }
        return islandCount;
    }
    /*public void dfs(char[][] grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0')
            return ;

        if(grid[r][c]=='2')
            return;

        grid[r][c]='2';

        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
        return;
    }
    public int numIslands(char[][] grid) {
        int island=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]=='1'){
                    island+=1;
                    dfs(grid,r,c);
                }
            }
        }
        return island;
    }*/
}