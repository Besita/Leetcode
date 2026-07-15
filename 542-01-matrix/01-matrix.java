class pair{
    int x;
    int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)
                    q.add(new pair(i,j));
                else
                    mat[i][j]=-1;
            }
        }

        while(!q.isEmpty()){
            pair curr=q.poll(); 
            int x=curr.x;
            int y=curr.y;     
            for(int k=0;k<4;k++){
                if(x+dx[k]>=0 && y+dy[k]>=0 && x+dx[k]<n && y+dy[k]<m && mat[x+dx[k]][y+dy[k]]==-1){
                    mat[x+dx[k]][y+dy[k]]=mat[curr.x][curr.y]+1;
                    q.add(new pair(x+dx[k],y+dy[k]));
                }
            }
    
        }
        return mat;        
    }
}