class Solution {
    public int lowerbound(int[] nums,int target){
        int end=nums.length-1;
        int start=0;
        int ans=end+1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    public int searchInsert(int[] nums, int target) {
       return lowerbound(nums,target);
    }
}