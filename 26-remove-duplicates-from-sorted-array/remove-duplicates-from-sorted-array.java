class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int prev=0;
        int curr=1;
        while(curr<n){
            while(curr<n && nums[curr]==nums[prev])
                curr++;
            if(curr>=n)
                break;
            if(nums[prev]<nums[curr]){
                int temp=nums[prev+1];
                nums[prev+1]=nums[curr];
                nums[curr]=temp;
                prev=prev+1;
            }
            else
                curr++;
        }
        return prev+1;
    }
}