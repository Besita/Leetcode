class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int ptr1=0;
        if(n==0)    
            return 0;
        for(int ptr2=0;ptr2<n;ptr2++){            
            if(nums[ptr2]!=val){
                int temp=nums[ptr2];
                nums[ptr2]=nums[ptr1];
                nums[ptr1]=temp;
                ptr1++;
            }            
        }
        return ptr1;
    }
}