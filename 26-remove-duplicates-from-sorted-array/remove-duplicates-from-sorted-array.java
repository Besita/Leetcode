class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int prev=0;
        for(int curr=1;curr<n;curr++){           
            if(nums[prev]!=nums[curr]){
                nums[prev+1]=nums[curr];
                prev++;
            }
        }
        return prev+1;
    }
}