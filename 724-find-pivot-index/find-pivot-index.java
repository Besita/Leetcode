class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        if(n==1)
            return 0;

        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
            prefix[i]=prefix[i-1]+nums[i];

        int[] suffix=new int[n];
        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
            suffix[i]=suffix[i+1]+nums[i];

        for(int i=0;i<n;i++){
            if(i==0){
                if(suffix[i+1]==0) return 0;
            } 
            else if(i==n-1){
                if(prefix[n-2]==0)  return n-1;
            }
            else{
                if(prefix[i-1]==suffix[i+1])
                    return i;
            }
        }
        return -1;
    }
}