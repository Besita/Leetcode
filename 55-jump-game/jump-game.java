class Solution {
    public boolean usingdp(int[] nums){
        int n=nums.length;
        boolean[] dp=new boolean[n];
        dp[n-1]=true;
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<=i+nums[i] && j<n;j++){
                dp[i]=dp[i] || dp[j];
            }
        }
        return dp[0];
    }
    public boolean optimized(int[] nums){
        int n=nums.length;
        int maxreach=0;
        for(int i=0;i<n;i++){
            if(i>maxreach)
                return false;
            maxreach=Math.max(nums[i]+i,maxreach);
        }
        //System.out.println(maxreach);
        //if(maxreach>=n-1)
          //  return true;
        return true;
    }
    public boolean canJump(int[] nums) {
        //return usingdp(nums);
        return optimized(nums);
    }
}