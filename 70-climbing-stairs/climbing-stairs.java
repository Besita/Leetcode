class Solution {
    int memoization(int n,int[] dp){
        if(n<=2)
            dp[n]=n;

        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n]=memoization(n-1,dp)+memoization(n-2,dp);
    }
    int recursion(int n){
        if(n<=2)
            return n;

        return recursion(n-2)+recursion(n-1);

    }
    int tabulation(int n){

        if(n<=2)
            return n;
            
        int[] dp=new int[n+1];
        //dp[0]=0;
        dp[1]=1; 
        dp[2]=2;
        
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;

        //recursion
        //return recursion(n);

        //memoization               
        //return memoization(n,dp);

        return tabulation(n);
        //tabulation
        

        /*//space optimised
        int prev2=1;
        int prev1=1;    
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;*/
    }
}