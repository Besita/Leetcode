class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        //return usingArray(nums,n); //TC:O(n*n)
        if(n<=1)
            return 0;
        return optimized(nums,n);//TC:O(n)
    }
    public int optimized(int[] nums,int n){
        int low=0;
        int high=0;
        int maxreach=0;
        int jump=0;
        while(high<n-1){
            maxreach=0;
            for(int i=low;i<=high;i++){
                System.out.println(low+" "+high);
                maxreach=Math.max(maxreach,i+nums[i]);
            }
            low=high+1;
            high=maxreach;                
            jump++;            
        }
        
        return jump;
    }
    public int usingArray(int[] nums,int n){
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){            
            for(int j=i+1;j<=i+nums[i] && j<n;j++){
                if(dp[j]!=Integer.MAX_VALUE)
                    dp[i]=Math.min(dp[i],dp[j]+1);
            }
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

}
