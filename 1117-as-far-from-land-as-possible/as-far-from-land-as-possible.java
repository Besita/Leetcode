class Solution {
    class pair{
        int r;
        int c;
        int max;
        pair(int r,int c,int max){
            this.r=r;
            this.c=c;
            this.max=max;
        }
    }

    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        int Time=Integer.MIN_VALUE;
        int water=0;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                    q.add(new pair(i,j,0));
                if(grid[i][j]==0)
                    water++;
            }
        }
        if(water==0)
            return -1;
        while(!q.isEmpty()){
            pair p=q.poll();
            int row=p.r;
            int col=p.c;
            int max=p.max;

            Time=Math.max(Time,max);
            for(int i=0;i<4;i++){
                if(row+dx[i]<0 || row+dx[i]>=n || col+dy[i]<0 || col+dy[i]>=m)
                    continue;
                if(grid[row+dx[i]][col+dy[i]]==0){ 
                    grid[row+dx[i]][col+dy[i]]=1;
                    //int dist=Math.abs(row-(row+dx[i])) + Math.abs(col-(col+dy[i]));
                    q.add(new pair(row+dx[i],col+dy[i],max+1));
                }
            }
        }
        if(Time==Integer.MIN_VALUE)
            return -1;
        return Time;
    }
}