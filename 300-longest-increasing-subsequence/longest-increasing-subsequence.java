class Solution {
    public void printlist(List<Integer> temp){
        System.out.println();
        for(int i:temp){
            System.out.print(i+" ");
        }
    }
    public int recursion(int idx,int n,int prev,int[] nums){
        if(idx==n)
            return 0;
        
        //not pick
        int notpick=0+recursion(idx+1,n,prev,nums);
        int pick=0;
        if(prev==-1 || nums[prev]<nums[idx])
            pick=1+recursion(idx+1,n,idx,nums);
        
        return Math.max(pick,notpick);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

       // return recursion(0,n,-1,nums);
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
        return dp(0,-1,n,nums,dp);
    }

    public int dp(int idx,int prev,int n,int[] nums,int[][] dp){
        if(idx==n){
            return 0;
        }

        if(dp[idx][prev+1]!=-1)
            return dp[idx][prev+1];
        
        int notpick=dp(idx+1,prev,n,nums,dp);
        //printlist(temp);
        int pick=0;
        if(prev==-1 || nums[prev]<nums[idx]){            
            pick=1+dp(idx+1,idx,n,nums,dp);
        }        
                
        //printlist(temp);
        return dp[idx][prev+1]=Math.max(pick,notpick);
    }





}