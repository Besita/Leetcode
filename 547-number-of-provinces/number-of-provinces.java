class Solution {
    public void dfs(int node,int[][] isConnected,int[] vis,int n){
        if(vis[node]==1)
            return;

        vis[node]=1;
        for(int i=0;i<n;i++){
            if(isConnected[node][i]==1 && node!=i){
                dfs(i,isConnected,vis,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] vis=new int[n];
        //Arrays.fill(vis,0);

        int province=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                province++;
                dfs(i,isConnected,vis,n);
            }
        }
        return province;     
    }
}