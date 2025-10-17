class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;

        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
            prefix[i]=prefix[i-1]+nums[i];

        int[] suffix=new int[n];
        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
            suffix[i]=suffix[i+1]+nums[i];

        int left=0,right=0;
        for(int i=0;i<n;i++){
            if(i==0)
                left=0;
            else
                left=prefix[i-1];

            if(i==n-1)
                right=0;
            else    
                right=suffix[i+1];
            
            if(left==right)
                return i;
        }
        return -1;
    }
}