class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){
           int dist=(points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
           pq.add(new int[]{dist,i});
           if(pq.size()>k){
              System.out.println(pq.poll()[0]);
           }
        }
        int[][] ans=new int[k][2];
        int i=0;
        while(k-- > 0){
            int[] curr=pq.poll();
            ans[i][0]=points[curr[1]][0];
            ans[i][1]=points[curr[1]][1];
            i++;
        }
        return ans;
    }
}