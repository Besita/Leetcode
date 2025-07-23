class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1 || (nums[0]<nums[n-1]))
            return nums[0];
        if(nums[n-2]>nums[n-1])
            return nums[n-1];
        
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(mid-1>=0 && nums[mid-1]>nums[mid])
                return nums[mid];
            else if(nums[mid]>nums[right]){ //min is in right half
                left=mid+1;
            }
            else
                right=mid-1;  //min is in left half
        }
        return -1;
    }
}