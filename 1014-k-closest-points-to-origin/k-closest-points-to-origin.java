
class Solution {
    public int[][] usingpriorityQueue(int[][] points, int k) {
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
    public int[][] usingsorting(int[][] points, int k) {
        int n=points.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
           int dist=(points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
           arr[i]=new int[]{dist,i};
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){        
            ans[i][0]=points[arr[i][1]][0];
            ans[i][1]=points[arr[i][1]][1];
        }
        return ans;
    }
    public int[][] kClosest(int[][] points, int k) {
        //return usingpriorityQueue(points,k);
        return usingsorting(points,k);
    }
}