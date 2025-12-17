class Solution {
    public boolean usingdp(int idx,int[] nums,int n){
        if(idx==n-1)
            return true;
        if(idx>=n || nums[idx]==0)
            return false;

        for(int i=1;i<=nums[idx];i++){
            //System.out.println(idx+i);
            if(usingdp(idx+i,nums,n)==true)
                return true;
        }
        return false;
    }
    
    public boolean usingmemo(int idx,int[] nums,int n,int[] dp){
        if(idx==n-1)
            return true;
        if(idx>=n || nums[idx]==0)
            return false;
        if(dp[idx]!=-1)
            return dp[idx]==1;

        for(int i=1;i<=nums[idx];i++){
            //System.out.println(idx+i);
            if(usingmemo(idx+i,nums,n,dp)==true){ 
                dp[idx]=1;
                return true;
            }
        }
        dp[idx]=0;
        return false;
    }

    public boolean optimized(int[] nums){
        int n=nums.length;
        int maxreach=0;
        for(int i=0;i<n;i++){
            if(i>maxreach)
                return false;
            maxreach=Math.max(nums[i]+i,maxreach);
        }
        return true;
    }
    public boolean canJump(int[] nums) {
        int n=nums.length;
        //return usingdp(0,nums,n);
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return usingmemo(0,nums,n,dp);
        //return optimized(nums);
    }
}