class Solution {
    public int usingArray(int[] nums){
        int n=nums.length;

        int onepresent=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1)
                onepresent=1;
            if(nums[i]<=0 || nums[i]>n)
                nums[i]=1;
        }
        if (onepresent==0)
            return 1;

        for(int i=0;i<n;i++){ 
            //System.out.println(" "+nums[i]);
            if(Math.abs(nums[i])==n)
               nums[0]=-Math.abs(nums[0]);
            else
                nums[Math.abs(nums[i])]=-Math.abs(nums[Math.abs(nums[i])]);
        }
        
        for(int i=2;i<n;i++){
            if(nums[i]>0)
                return i;
        }
        if(nums[0]>0)
            return n;
        return n+1;
    }
    public int firstMissingPositive(int[] nums) {
        return usingArray(nums);//TC:O(n) SC:O(n) 
        //return optimized(nums);//TC:O(n) SC:O(1)
        
    }
}