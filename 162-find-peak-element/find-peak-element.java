class Solution {
    public int method1(int[] nums){
        int s=0;
        int e=nums.length-1;
        int ans=0;
        if(s==e)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[e]>nums[e-1])
            return e;
        while(s<=e){
            int mid=(s+e)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1] ){ 
                ans=mid;
                break;
            }
            if(nums[mid]<nums[mid+1] )
                s=mid+1;
            else
                e=mid-1;
        }
        return ans;
    }
    public int method2(int[] nums){
        int n=nums.length;
        if(n==1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        else if(nums[n-1]>nums[n-2])
            return n-1;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if( nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1] )
                return mid;
            else if(nums[mid] > nums[mid+1])
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
    public int findPeakElement(int[] nums) {
        //return method1(nums);
        return method2(nums);
    }
}