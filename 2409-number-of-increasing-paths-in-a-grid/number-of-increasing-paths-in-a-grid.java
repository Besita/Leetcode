class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    int mod=(int)1e9+7;
    public int dp(int row,int col,int m,int n,int[][] dp,int[][] grid){
        if(dp[row][col]!=-1)
            return dp[row][col];

        int count=1;
        for(int i=0;i<4;i++){
            int nr=row+dx[i];
            int nc=col+dy[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]>grid[row][col])
                count=((count%mod)+(dp(nr,nc,m,n,dp,grid)%mod))%mod;
        }
        return dp[row][col]=count;
    }
    public int countPaths(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count=((count%mod)+(dp(i,j,m,n,dp,grid)%mod))%mod;
                //System.out.println(count);
            }
        }
        return count;
    }
}