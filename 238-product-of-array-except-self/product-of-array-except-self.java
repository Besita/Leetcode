class Solution {
    public int[] prefixsuffix(int[] nums){
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
            prefix[i]=nums[i]*prefix[i-1];
        for(int i=n-2;i>=0;i--)
            suffix[i]=nums[i]*suffix[i+1];

        int[] ans=new int[n];
        for(int i=0;i<n;i++){ //O(n)
            if(i==0)
                ans[i]=suffix[i+1];
            else if(i==n-1)
                ans[i]=prefix[i-1];
            else
                ans[i]=prefix[i-1]*suffix[i+1];
        }
        return ans;
    }
    public int[] prefixsuffixoptimised(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int prefixproduct=1;
        int suffixproduct=1;
        for(int i=0;i<n;i++){ 
            ans[i]=prefixproduct;
            prefixproduct*=nums[i];
        }

        for(int i=n-1;i>=0;i--){
            ans[i]*=suffixproduct;
            suffixproduct*=nums[i];
        }
        return ans;
    }
    public int[] bruteforce(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int prod=1;
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                prod*=nums[j];
            }
            ans[i]=prod;
        }
        return ans;
    }
    public int[] productExceptSelf(int[] nums) {

        //TC:O(n*n)
        //return bruteforce(nums);

        //TC:O(n)
        //return prefixsuffix(nums);

        //TC:O(n)
        return prefixsuffixoptimised(nums);       
        
    }
}