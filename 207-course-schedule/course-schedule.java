class Solution {
    public boolean dfs(int node,int n,List<Integer>[] adj,int[] vis,int[] pathvis){
        if(pathvis[node]==1)
            return false;
        
        if(vis[node]==1)
            return true;
        
        vis[node]=1;
        pathvis[node]=1;
        for(int i:adj[node]){
            if(!dfs(i,n,adj,vis,pathvis))
                return false;
        }
        pathvis[node]=0;
        return true;
    }
    public boolean usingDFS(int numCourses,int[][] edges){
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i]=new ArrayList<>();

        for(int[] i:edges)
            adj[i[1]].add(i[0]);

        int[] vis=new int[numCourses];
        int[] pathvis=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){ 
                if(!dfs(i,numCourses,adj,vis,pathvis))
                    return false;
            }
        }        
        return true;
    }
    public boolean usingBFS(int numCourses,int[][] edges){
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i]=new ArrayList<>();

        int[] indegree=new int[numCourses];
        for(int[] i:edges){
            adj[i[1]].add(i[0]);
            indegree[i[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:adj[node]){
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
            ans.add(node);
        }
        if(ans.size()==numCourses)
            return true;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] edges) {
        //return usingDFS(numCourses,edges);
        return usingBFS(numCourses,edges);
    }
}