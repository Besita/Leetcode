class Solution {
    public boolean dfs(int node,int V,int[] vis,int[] pathvis,int[][] graph,int[] check){
        if(pathvis[node]==1){  //same path i.e cycle is present
            return true;
        }
        if(vis[node]==1) //already visited in another path, not current path i.e no  cycle
            return false;

        vis[node]=1;
        pathvis[node]=1;
        for(int i:graph[node]){
            if(dfs(i,V,vis,pathvis,graph,check)) //if cycle return , else make pathvis==0
                return true;
        }
        pathvis[node]=0;
        check[node]=1;
        return false;
    }

    public List<Integer> usingDfsDAG(int[][] graph) {
        int V=graph.length;
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        int[] check=new int[V];
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,V,vis,pathvis,graph,check);
            }
        }
        for(int i=0;i<V;i++){
            if(check[i]==1)
                ans.add(i);
        }
        return ans;
    }
    public List<Integer> usingBFSTopoSort(int[][] graph){
        int V=graph.length;
        int[] indegree=new int[V];
        List<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++)
            adj[i]=new ArrayList<>();

        for(int i=0;i<V;i++){  // build adj matrix and indegree
            for(int j=0;j<graph[i].length;j++){ 
                adj[graph[i][j]].add(i);
                indegree[i]++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>(); 
        for(int i=0;i<V;i++){
            if(indegree[i]==0){ 
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int i:adj[node]){
                indegree[i]--;
                if(indegree[i]==0){ 
                    q.add(i);
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        //return usingDfsDAG(graph);
        return usingBFSTopoSort(graph);
        
    }
}