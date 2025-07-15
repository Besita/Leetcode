class Solution {

    public int[] usingArrays(int[][] mat,int k){
        //we no need to use priorityqueue since sorting is needed onlt 1 time.
        //we can further optimise by using binary search for counting soldiers
        // since soldiers are standing before civilians
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

    public int findStrength(int[][] mat,int r,int left,int right){
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(mat[r][mid]==1 && mat[r][mid+1]==0){ 
                ans=mid+1;
                break;
            }
            else if(mat[r][mid]==0)
                right=mid-1;
            else
                left=mid+1;
        }
        return ans;
    }
     public int[] usingBinarysearch(int[][] mat,int k){
        int m=mat.length;
        int n=mat[0].length;
        int[][] pq=new int[m][2];
        for(int i=0;i<m;i++){
            int rowsum=0;
            int left=0;
            int right=n-1;
            if(mat[i][0]==0) 
                pq[i][0]=0;
            else  if(mat[i][right]==1)
                pq[i][0]=n;
            else
                pq[i][0]=findStrength(mat,i,left,right);
                   
            pq[i][1]=i; 
        }
        Arrays.sort(pq,(a,b)->(a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq[i][1];
        }
        return ans;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        //return usingArrays(mat,k); //TC:O(n*m(calculating strength) + nlogn(sort)) SC:O(n*2) //3ms
        return usingBinarysearch(mat,k); ////TC:O(n*logm(calculating strength) + nlogn(sort)) SC:O(n*2)  //2ms
    }
}