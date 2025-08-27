class Solution {
 
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
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
}