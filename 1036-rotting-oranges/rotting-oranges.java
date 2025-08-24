class pair{
    int r;
    int c;
    int min;
    pair(int r,int c,int min){
        this.r=r;
        this.c=c;
        this.min=min;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        int Time=0;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    q.add(new pair(i,j,0));
                    System.out.println(i+" "+j+" "+0);
            }
        }

        while(!q.isEmpty()){
            pair p=q.poll();
            int row=p.r;
            int col=p.c;
            int min=p.min;

            Time=Math.max(Time,min);
            for(int i=0;i<4;i++){
                if(row+dx[i]<0 || row+dx[i]>=n || col+dy[i]<0 || col+dy[i]>=m)
                    continue;
                if(grid[row+dx[i]][col+dy[i]]==1){ 
                    grid[row+dx[i]][col+dy[i]]=2;
                    q.add(new pair(row+dx[i],col+dy[i],min+1));
                   // System.out.println((row+dx[i])+" "+(col+dy[i])+" "+(min+1));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return Time;
    }
}