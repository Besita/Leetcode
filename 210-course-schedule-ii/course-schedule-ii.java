class Solution {
    public int[] usingBFSTopoSort(int numCourses, int[][] prerequisites){
        int[] indegree=new int[numCourses];
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i]=new ArrayList<>();

        for(int[] i:prerequisites){  // build adj matrix and indegree
            adj[i[1]].add(i[0]);
            indegree[i[0]]++;
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>(); 
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){ 
                ans.add(i);
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:adj[node]){
                indegree[i]--;
                if(indegree[i]==0){ 
                    q.add(i);
                    ans.add(i);
                }
            }
        }
            
        int[] res=ans.stream().mapToInt(Integer::intValue).toArray();
        if(res.length!=numCourses)
            return new int[0];
        return res;
    }
    public boolean dfs(int node,int n,List<Integer>[] adj,int[] vis,int[] pathvis,Stack<Integer> st){
        if(pathvis[node]==1)
            return false;
        
        if(vis[node]==1)
            return true;
        
        vis[node]=1;
        pathvis[node]=1;
        for(int i:adj[node]){
            if(!dfs(i,n,adj,vis,pathvis,st))
                return false;
        }
        pathvis[node]=0;
        st.push(node);
        return true;
    }
    public int[] usingDFS(int numCourses, int[][] prerequisites){
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i]=new ArrayList<>();

        for(int[] i:prerequisites)
            adj[i[1]].add(i[0]);

        int[] vis=new int[numCourses];
        int[] pathvis=new int[numCourses];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){ 
                if(!dfs(i,numCourses,adj,vis,pathvis,st))
                    return new int[0];
            }
        }       
        int[] ans=new int[numCourses];
        int i=0;
        while(!st.empty()){
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //return usingBFSTopoSort(numCourses,prerequisites);
        return usingDFS(numCourses,prerequisites);
    }
}