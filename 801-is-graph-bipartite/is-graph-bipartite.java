class Solution {
    public boolean bfs(int start,int n,int[][] graph,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(start); 
        color[start]=0;       
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int next:graph[curr]){
                if(color[next]==-1){ 
                    color[next]=1-color[curr];
                    q.add(next);
                }
                else if(color[next]==color[curr])
                    return false;
            }

        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){ 
                if(!bfs(i,n,graph,color))
                    return false;
            }
        }
        return true;
    }
}