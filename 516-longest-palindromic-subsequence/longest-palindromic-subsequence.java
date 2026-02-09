class Solution {
    public int recursion(int left,int right,String s){
        if(left>right)
            return 0;
        else if(left==right)
            return 1;

        int take=0;
        if(s.charAt(left)==s.charAt(right))
            take=2+recursion(left+1,right-1,s);
        int nottake=Math.max(recursion(left+1,right,s),recursion(left,right-1,s));

        return Math.max(take,nottake);
        
    }
    public int memoization(int left,int right,String s,int[][] dp){
        if(left>right)
            return 0;
        else if(left==right)
            return 1;

        if(dp[left][right]!=-1)
            return dp[left][right];

        int take=0;
        if(s.charAt(left)==s.charAt(right))
            take=2+memoization(left+1,right-1,s,dp);
        else
            take=Math.max(memoization(left+1,right,s,dp),memoization(left,right-1,s,dp));

        return dp[left][right]=take;
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        //return recursion(0,n-1,s);
        return memoization(0,n-1,s,dp);
    }
}