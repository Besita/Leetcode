class Solution {
    public int dp(int sum,int idx,int n,int[] nums,int target){
        if(idx<0){
            if(sum==target)
                return 1;
            else
                return 0;
        }
        int pick=0,notpick=0;        
        pick=nums[idx]+dp(sum+nums[idx],idx-1,n,nums,target);
        notpick=-nums[idx]+dp(sum-nums[idx],idx-1,n,nums,target);
        return (pick+notpick);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return dp(0,n-1,n,nums,target);
    }
}