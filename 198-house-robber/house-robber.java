class Solution {
    public int recursion(int n,int[] nums){
        if(n==0)
            return nums[0];
        if(n<0)
            return 0;

        int pick=nums[n]+recursion(n-2,nums);
        int notpick=recursion(n-1,nums);
        return Math.max(pick,notpick);
    }
    public int memoization(int n,int[] nums,int[] dp){
        if(n==0)
            return dp[0];
        if(n<0)
            return 0;

        if(dp[n]!=-1)
            return dp[n];

        int pick=nums[n]+memoization(n-2,nums,dp);
        int notpick=memoization(n-1,nums,dp);
        return dp[n]=Math.max(pick,notpick);
    }
    
    public int tabulation(int[] nums){
        int n=nums.length;
        int maxval=0;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int pick=nums[i]+dp[i-2];
            int notpick=dp[i-1];
            dp[i]=Math.max(pick,notpick);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int n=nums.length-1;
    
        //return recursion(n,nums);
        /*//memoization
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;
        dp[0]=nums[0];
        return memoization(n,nums,dp);*/

        //tabulation
        return tabulation(nums);

        /*//space optimised
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<=n;i++){
            int pick=nums[i],notpick=0;
            if((i-2)>=0)
                pick+=prev2;
            notpick=prev1;
            int curr=Math.max(pick,notpick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;*/
    }
}