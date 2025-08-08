class Solution {
    int[] dx={0,0,-1,1};
    int[] dy={-1,1,0,0};
    public int dp(int row,int col,int m,int n,int[][] matrix,int[][] dp){

        if(dp[row][col]!=-1)
            return dp[row][col];

        int count=1;

        for(int i=0;i<4;i++){
            int nr=row+dx[i];
            int nc=col+dy[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && matrix[nr][nc]>matrix[row][col])
                count=Math.max(count,1+dp(nr,nc,m,n,matrix,dp));
        }

        return dp[row][col]=count;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);

        int maxpathlength=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){                
                int length=dp(i,j,m,n,matrix,dp);
                maxpathlength=Math.max(maxpathlength,length);
            }
        }
        return maxpathlength;
    }
}