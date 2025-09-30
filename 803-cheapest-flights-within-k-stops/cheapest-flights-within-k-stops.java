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
        
                if(currdist+dist1<mindist[dest1] && currstop<=k){ 
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

/*class Solution {
    // Edge class to represent a flight connection - Graph
    class Edge{
        int src;   // source airport
        int dest;  // destination airport
        int price;  // cost of this flight
        Edge(int src, int dest, int price){
            this.src=src;
            this.dest=dest;
            this.price=price;
        }
    }
    // Info class to store current path details for BFS traversal
    class Info{
        int dest;   // current airport
        int price;  // total price to reach this airport
        int stops;  // number of stops taken so far
        Info(int dest, int price, int stops){
            this.dest=dest;
            this.price=price;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Build adjacency list graph
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int price = flights[i][2];
            graph[u].add(new Edge(u, v, price));
        }

        // Disjkstra Algorithm (Modified)
        int[] dist = new int[n];  // Distance array to store min cost to reach each node
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();  // BFS queue storing (node, cost, stops)
        q.add(new Info(src, 0, 0));  // start from source with cost 0 and stops 0

        while(!q.isEmpty()){
            Info curr = q.remove();

            // if stops exceed k, skip further exploration from this path
            if(curr.stops>k){
                continue;
            }
            
            // explore all neighbors of current airport
            for(Edge e : graph[curr.dest]){
                int u = e.src;
                int v = e.dest;
                int price = e.price;

                // check if reaching v through curr is cheaper and within allowed stops
                if(curr.price + price<dist[v] && curr.stops<=k){
                    dist[v] = curr.price + price;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;  // no valid path found
        }
        return dist[dst];
    }
}*/