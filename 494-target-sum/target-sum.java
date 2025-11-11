class Solution {
    public int dp(int[] nums,int target,int n,int curr,int[][] dp){
        if(n<0 && curr==target)
            return 1;
        else if(n<0)   
            return 0;

        if(dp[n][curr]!=-1)
            return dp[n][curr];

        int positive=recursion(nums,target,n-1,curr+nums[n]);        
        int negative=recursion(nums,target,n-1,curr-nums[n]);

        return dp[n][curr]=positive+negative;
        
    }
    int recursion(int[] nums,int target,int n,int curr){
        if(n<0 && curr==target)
            return 1;
        else if(n<0)   
            return 0;

        int positive=recursion(nums,target,n-1,curr+nums[n]);        
        int negative=recursion(nums,target,n-1,curr-nums[n]);

        return positive+negative;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        //return recursion(nums,target,n-1,0);

        int[][] dp=new int[n][2001];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return dp(nums,target,n-1,0,dp); 
    }
}