class Solution {
    public int topdown(int n){
        int[] f=new int[n+1];        
        if(n<=1)
            return n;
        f[0]=0;
        f[1]=1;
        for(int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }
    public int recursion(int n){
        if(n<=1)
            return n;

        return recursion(n-1)+recursion(n-2);
    }
    public int memoization(int n,int[] dp){      
        if(dp[n]!=-1)
            return dp[n];

        return dp[n] = memoization(n-1,dp)+memoization(n-2,dp);
    }
    public int fib(int n) {
        //return topdown(n);
        //return recursion(n);
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }

        if(n<=1)
            return n;
            
        dp[0]=0;
        dp[1]=1;
        return memoization(n,dp);
    }
}