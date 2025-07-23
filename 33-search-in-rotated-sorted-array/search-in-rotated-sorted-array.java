class Solution {
    public int method1(int[] nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        
        if(nums[low]==target)
            return low;
        else if(nums[high]==target)
            return high;
        else if(n==1)
            return -1;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<=nums[high]){//sorted on right half
                if(nums[mid]<=target && nums[high]>=target)
                    low=mid+1;
                else
                    high=mid-1;
            }
            else{
                if(nums[low]<=target && nums[mid]>=target)
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        return -1;
    }
    public int method2(int[] nums,int target){
        int n=nums.length;
        if(nums[0]==target)
            return 0;
        if(nums[n-1]==target)
            return n-1;
        if(n==1)
            return -1;
        
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)
                return mid;
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
        return -1; 
    }
    public int search(int[] nums, int target) {
        //return method1(nums,target);
        return method2(nums,target);
    }
}