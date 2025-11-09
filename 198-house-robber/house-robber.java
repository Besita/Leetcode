
class Solution {
    int recursion(int[] nums,int n){
        if(n<0)
            return 0;
        if(n==0)
            return nums[0];
        
        int pick=nums[n]+recursion(nums,n-2);
        int notpick=recursion(nums,n-1);

        return Math.max(pick,notpick);
    }
    int memoization(int[] nums,int n,int[] memo){
        if(n<0)
            return 0;
        if(n==0)
            return nums[0];
        
        if(memo[n]!=-1)
            return memo[n];
        
        int pick=nums[n]+memoization(nums,n-2,memo);
        int notpick=memoization(nums,n-1,memo);

        memo[n]=Math.max(pick,notpick);
        return memo[n];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        //return recursion(nums,n-1);  //TLE
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return memoization(nums,n-1,memo);        
    }
}