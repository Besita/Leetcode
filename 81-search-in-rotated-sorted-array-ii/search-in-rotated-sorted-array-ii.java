class Solution {
    public boolean method1(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target)
                return true;
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }            
            if(nums[mid]<=nums[high]){//sorted on right half
                if(nums[mid]<=target && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
            else{
                if(nums[low]<=target && target<=nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        return false;
    }
    public boolean method2(int[] nums,int target){
        int n=nums.length;
        if(nums[0]==target || nums[n-1]==target )
            return true;
        if(n==1)
            return false;
        
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+right)/2;            
            if(nums[mid]==target)
                return true;
            else if(nums[left]==nums[mid] && nums[mid]==nums[right]){
                left++;
                right--;
                continue;
            }            
            else if(nums[left]<=nums[mid]){ //left is sorted
                if(nums[left]<=target && target<=nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
            else{
                if(nums[mid]<=target && target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return false; 
    }
    public boolean search(int[] nums, int target) {
        //return method1(nums,target);
        return method2(nums,target);
    }
}