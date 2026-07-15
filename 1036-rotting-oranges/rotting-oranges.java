class pair{
    int x;
    int y;
    int min;
    pair(int r,int c,int min){
        this.x=r;
        this.y=c;
        this.min=min;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    q.add(new pair(i,j,0));
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        int maxTime=0;

        int dx[]={-1,1,0,0};
        int dy[]={0,0,-1,1};
        while(!q.isEmpty()){
            pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            int time=curr.min;
            maxTime=Math.max(maxTime,time);
            for(int i=0;i<4;i++){
                int x1=x+dx[i];
                int y1=y+dy[i];
                if(x1>=0 && y1>=0 && x1<n && y1<m && grid[x1][y1]==1){
                    grid[x1][y1]=2;
                    fresh--;
                    q.add(new pair(x1,y1,time+1));
                }
            }
        }
        if(fresh==0)
            return maxTime;
        
        return -1;
    }
}