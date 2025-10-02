class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public void dfs(int[][] image,int sr,int sc,int n,int m,int color,int orig){
        if(image[sr][sc]==color || image[sr][sc]!=orig)
            return;

        image[sr][sc]=color;
        if(sr-1>=0) 
            dfs(image,sr-1,sc,n,m,color,orig);
        if(sr+1<n)
            dfs(image,sr+1,sc,n,m,color,orig);
        if(sc-1>=0)
            dfs(image,sr,sc-1,n,m,color,orig);
        if(sc+1<m)
            dfs(image,sr,sc+1,n,m,color,orig);

    }
    public int[][] UsingBFSGraph(int[][] image,int sr,int sc,int color,int n,int m){
        int orig=image[sr][sc];
        if(orig==color)
            return image;
        
        image[sr][sc]=color;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            for(int i=0;i<4;i++){
                int x1=x+dx[i];
                int y1=y+dy[i];
                if(x1>=0 && x1<n && y1>=0 && y1<m && image[x1][y1]==orig){
                    image[x1][y1]=color;
                    q.add(new Pair(x1,y1));
                }
            }
        }
        return image;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        
        /*//method1
        UsingDp(image,sr,sc,n,m,color,image[sr][sc]);
        return image;*/
        //method 2
        return UsingBFSGraph(image,sr,sc,color,n,m);
    }
}