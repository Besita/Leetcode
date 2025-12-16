class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int k=0,i=0;
        if(n==0)    
            return 0;
        while(i<n){            
            if(nums[i]!=val){
                int temp=nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                k++;
            }            
            i++;
        }
        return k;
    }
}