class Solution {
    public int dp(int sum,int idx,int n,int[] nums,int target,int[][] dp){
        return 0;
    }
    int recursion(int[] nums,int target,int n,int curr){
        if(n<0 && curr==target)
            return 1;
        else if(n<0)   
            return 0;

        int pick=nums[n]+recursion(nums,target,n-1,curr+nums[n]);        
        int notpick=-nums[n]+recursion(nums,target,n-1,curr-nums[n]);

        return pick+notpick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return recursion(nums,target,n-1,0);
        /*int[][] dp=new int[n][2001];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return dp(0,n-1,n,nums,target,dp); */
    }
}