class Solution {
    public boolean dfs(int node,int V,int[] vis,int[] pathvis,int[][] graph,int[] safe){
        if(pathvis[node]==1){ 
            //safe[node]=0;
            return true;
        }
        if(vis[node]==1)
            return false;

        vis[node]=1;
        pathvis[node]=1;
        for(int i:graph[node]){
            if(dfs(i,V,vis,pathvis,graph,safe))
                return true;
        }
        pathvis[node]=0;
        safe[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        int[] safe=new int[V];
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,V,vis,pathvis,graph,safe);
            }
        }
        for(int i=0;i<V;i++){
            if(safe[i]==1)
                ans.add(i);
        }
        return ans;
    }
}