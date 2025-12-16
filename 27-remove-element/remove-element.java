class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int k=0;
        if(n==0)    
            return 0;
        for(int i=0;i<n;i++){            
            if(nums[i]!=val){
                int temp=nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                k++;
            }            
        }
        return k;
    }
}