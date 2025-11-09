class Solution {
    int memoization(int n,int[] memo){
        if(n<=2)
            return n;
        
        if(memo[n]!=-1)
            return memo[n];
        
        memo[n] = memoization(n-1,memo)+memoization(n-2,memo);
        return memo[n];
    }
    public int climbStairs(int n) {
        /*//method1
        if(n<=2)
            return n;
        int[] f=new int[n+1];
        f[1]=1;
        f[2]=2;
        for(int i=3;i<=n;i++)
            f[i]=f[i-1]+f[i-2];
        return f[n];*/

        /*//method2  TLE recursion
        if(n<=2)
            return n;
        
        return climbStairs(n-1)+climbStairs(n-2);*/
        
        //method3
        if(n<=2)
            return n;
        int []memo=new int[n+1];
        Arrays.fill(memo,-1);
        memo[1]=1;
        memo[2]=2;
        return memoization(n,memo);
        
    }
}