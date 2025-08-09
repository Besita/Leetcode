class Solution {
    public int dp(int sum,int idx,int n,int[] nums,int target,int[][] dp){
        if(idx<0){
            if(sum==target)
                return 1;
            else
                return 0;
        }
        if(dp[idx][sum+1000]!=-1)
            return dp[idx][sum+1000];

        int add=0,subtract=0;        
        add=nums[idx]+dp(sum+nums[idx],idx-1,n,nums,target,dp);
        subtract=-nums[idx]+dp(sum-nums[idx],idx-1,n,nums,target,dp);
        return dp[idx][sum+1000]=add+subtract;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int[][] dp=new int[n][2*1000+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return dp(0,n-1,n,nums,target,dp);
    }
}