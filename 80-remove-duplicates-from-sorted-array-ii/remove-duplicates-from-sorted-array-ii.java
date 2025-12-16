class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int prev=0;
        if(n<=2)
            return n;
        
        for(int curr=2;curr<n;curr++){
            if(nums[prev]!=nums[curr]){
                nums[prev+2]=nums[curr];
                prev++;
            }           
        }
        return prev+2;
    }
}