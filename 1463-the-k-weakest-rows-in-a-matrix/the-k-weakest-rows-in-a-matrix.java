class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //priorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>(a->b -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        
        int m=mat.length;
        int n=mat[0].length;
        int[][] pq=new int[m][2];
        for(int i=0;i<m;i++){
            int rowsum=0;
            for(int j=0;j<n;j++){
                rowsum+=mat[i][j];
                if(mat[i][j]==0)
                    break;
            }
            pq[i][0]=rowsum;
            pq[i][1]=i;
        }
        Arrays.sort(pq,(a,b)->(a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq[i][1];
        }
        return ans;
    }
}