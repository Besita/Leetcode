class Solution {
    public class Pair{
        int dest;
        int dist;
        int stop;
        Pair(int dest,int dist,int stop){
            this.dest=dest;
            this.dist=dist;
            this.stop=stop;
        }
        Pair(int dest,int dist){
            this.dest=dest;
            this.dist=dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Pair>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] i:flights){
            int u=i[0];
            int v=i[1];
            int w=i[2];
            adj[u].add(new Pair(v,w));
        }

        Queue<Pair> q=new LinkedList<>();
        int[] mindist = new int[n];
        Arrays.fill(mindist,Integer.MAX_VALUE);
        q.add(new Pair(src,0,0));
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int currdest=temp.dest;
            int currdist=temp.dist;
            int currstop=temp.stop;
            if(currstop>k)
                break;
            for(Pair i:adj[currdest]){
                int dest1=i.dest;
                int dist1=i.dist;        
                if(currdist+dist1<mindist[dest1] ){//&& currstop<=k){ 
                    mindist[dest1]=currdist+dist1;
                    q.add(new Pair(dest1,mindist[dest1],currstop+1));     
                } 
            }           
        }
        if(mindist[dst]==Integer.MAX_VALUE)
            return -1;
        return mindist[dst];        
    }
}
