class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int prev=0;
        //if(n<=2)
          //  return n;
        int occurence=1;
        for(int curr=1;curr<n;curr++){
            if(nums[prev]!=nums[curr]){
                nums[prev+1]=nums[curr];
                prev++;
                occurence=1;
            }
            else if(nums[prev]==nums[curr] && occurence==1){
                nums[prev+1]=nums[curr];
                prev++;
                occurence=2;
            }
        }
        return prev+1;
    }
}