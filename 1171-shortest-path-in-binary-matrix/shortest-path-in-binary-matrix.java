class pair{
    int x;
    int y;
    int dist;
    pair(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1)
            return -1;
        int[] dx={-1,-1,-1,0,0,1,1,1};
        int[] dy={-1,0,1,-1,1,-1,0,1};
        Queue<pair> q=new LinkedList<>();
        //int[][] visited=new int[n][m];
        q.add(new pair(0,0,1));
        //visited[0][0]=1;
        grid[0][0]=1;
        while(!q.isEmpty()){            
            pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            int dist=curr.dist;
            if(x==n-1 && y==m-1)
                return dist; 

            for(int i=0;i<8;i++){            
                int newx=x+dx[i];
                int newy=y+dy[i];                    
                if(newx<0 || newy<0 || newx>=n || newy>=m)
                    continue;   

                if(grid[newx][newy]==0){
                    q.add(new pair(newx,newy,dist+1));
                    grid[newx][newy]=1;
                }                                   
            }            
        }
        return -1;
    }
}