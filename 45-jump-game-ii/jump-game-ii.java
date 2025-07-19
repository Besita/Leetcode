class Solution {
    
    public int recursion(int[] nums,int curr,int n){
        if(curr==n-1){
            return 0;
        }

        int minjump=Integer.MAX_VALUE;              
        for(int i=1;i<=nums[curr];i++){
            //System.out.println("before: "+(curr+i)+" "+nums[curr+i]+" "+minjump);  
            if(curr+i<n)
                minjump=Math.min(minjump,1+recursion(nums,curr+i,n));
            //System.out.println("after: "+(curr+i)+" "+nums[curr+i]+" "+minjump); 
        }
        return minjump;
    }
    public int jump(int[] nums) {
        int n=nums.length;
       //return recursion(nums,0,n);
       return usingArray(nums,n); //TC:O(n*n)
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
