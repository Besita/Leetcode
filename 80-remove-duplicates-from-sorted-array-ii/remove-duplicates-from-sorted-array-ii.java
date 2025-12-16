class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int prev=0;
        if(n<=2)
            return n;
        int start=1;
        if(nums[prev]==nums[prev+1]){ 
            prev++;
            start++;
        }
        for(int curr=start;curr<n;curr++){
            if(nums[prev]!=nums[curr]){
                nums[prev+1]=nums[curr];
                prev++;
                if(curr+1<n && nums[curr]==nums[curr+1]){ 
                    nums[prev+1]=nums[curr];
                    prev++;
                }
            }
            
        }
        return prev+1;
    }
}