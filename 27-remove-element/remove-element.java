class Solution {
    public int removeElement(int[] nums, int val) {
        int n2=nums.length-1;
        int n1=0;
        if(n2<0)    
            return 0;
        while(n1<=n2){
            while(n2>=0 && nums[n2]==val)
                n2--;
            if(n2<0)
                return 0;
            if(n1>n2)
                return n1;
            if(nums[n1]==val){
                int temp=nums[n1];
                nums[n1]=nums[n2];
                nums[n2]=temp;
                n1++;
                n2--;
            }
            else
                n1++;
        }
        return n1;
    }
}