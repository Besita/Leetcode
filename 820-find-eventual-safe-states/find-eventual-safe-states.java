class Solution {
    public boolean dfs(int node,int V,int[] vis,int[] pathvis,int[][] graph){
        if(pathvis[node]==1){  //same path i.e cycle is present
            return true;
        }
        if(vis[node]==1) //already visited in another path, not current path i.e no  cycle
            return false;

        vis[node]=1;
        pathvis[node]=1;
        for(int i:graph[node]){
            if(dfs(i,V,vis,pathvis,graph)) //if cycle return , else make pathvis==0
                return true;
        }
        pathvis[node]=0;
        return false;
    }

    public List<Integer> usingDfsDAG(int[][] graph) {
        int V=graph.length;
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,V,vis,pathvis,graph);
            }
        }
        for(int i=0;i<V;i++){
            if(vis[i]==1 && pathvis[i]==0)
                ans.add(i);
        }
        return ans;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        return usingDfsDAG(graph);
        
    }
}