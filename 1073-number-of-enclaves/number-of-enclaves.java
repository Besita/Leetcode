class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public void bfs(int r,int c,int n,int m,int[][] vis,int[][] grid){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c));
        vis[r][c]=1;
        grid[r][c]=0;

        while(!q.isEmpty()){
            Pair ord=q.poll();
            int x=ord.x;
            int y=ord.y;
            for(int i=0;i<4;i++){ 
                if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m && vis[x+dx[i]][y+dy[i]]==0 && grid[x+dx[i]][y+dy[i]]==1){
                    q.add(new Pair(x+dx[i],y+dy[i]));
                    vis[x+dx[i]][y+dy[i]]=1;
                    grid[x+dx[i]][y+dy[i]]=0;
                }
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(vis[i],0);

        for(int i=0;i<n;i++){    
            if(grid[i][0]==1)        
                bfs(i,0,n,m,vis,grid);
            if(grid[i][m-1]==1)  
                bfs(i,m-1,n,m,vis,grid);            
        }
        for(int j=0;j<m;j++){     
            if(grid[0][j]==1)          
                bfs(0,j,n,m,vis,grid);
            if(grid[n-1][j]==1)   
                bfs(n-1,j,n,m,vis,grid);            
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                    count++;
            }
        }
        return count;
    }
}