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
                if(color[next]==color[curr])
                    return false;
            }

        }
        return true;
    }
    public boolean dfs(int node,int prev,int n,int[][] graph,int[] color){
        if(prev==-1)
            color[node]=0;
        else
            color[node]=1-color[prev];

        for(int next:graph[node]){
            if(color[next]==-1){ 
                if(!dfs(next,node,n,graph,color))
                    return false;
            }
            if(color[next]==color[node])
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){ 
                /*if(!bfs(i,n,graph,color))
                    return false;*/
                if(!dfs(i,-1,n,graph,color))
                    return false;
            }
        }
        return true;
    }
}