class Solution {
    public int usingNegation(int[] nums){
        //loop and check whether 1 is there, if no return 1.
        //use negation technique for numbers from [1-n-1]. 
        //use idx 0 to track n
        //if all these numbers are present the missing should be n+1
        
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
    public void swap(int[] arr,int a,int b){
        int c=arr[a];
        arr[a]=arr[b];
        arr[b]=c;
    }
    public int optimized(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0 && nums[i]<=n && nums[i]!=nums[nums[i]-1])
                swap(nums,i,nums[i]-1);
        }
        for(int i=0;i<n;i++)
            System.out.print(" "+nums[i]);

        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return n+1;
    }
    public int firstMissingPositive(int[] nums) {
        //return usingNegation(nums);//TC:O(n) SC:O(n) 
        return optimized(nums);//TC:O(n) SC:O(1)
        
    }
}