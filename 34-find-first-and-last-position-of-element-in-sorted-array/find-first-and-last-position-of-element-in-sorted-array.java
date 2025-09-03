 class Solution {    
    /*public int findStartPos(int[] nums,int s,int e,int target){
        int ans=-1;
        
        while(s<=e){
            int mid=(s+e)/2;
            if(nums[mid]==target){ 
                ans=mid;
                e=mid-1;
            }
            else if(nums[mid]<target)
                s=mid+1;
            else if(nums[mid]>target)
                e=mid-1;
        }
        return ans;
    }

    public int findEndPos(int[] nums,int s,int e,int target){
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(nums[mid]==target){ 
                ans=mid;
                s=mid+1;
            }
            else if(nums[mid]<target)
                s=mid+1;
            else if(nums[mid]>target)
                e=mid-1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int s=0;
        int e=n-1;
 
        int start=findStartPos(nums,s,e,target);
        int end=findEndPos(nums,s,e,target);
               
        return new int[]{start,end};
    }   */
    int findlower(int[] nums,int target){
        int n=nums.length;
        int start=0;
        int end=n-1;
        int ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){ 
                ans=mid;
                end=mid-1;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return ans;
    }
    int findupper(int[] nums,int target){
        int n=nums.length;
        int start=0;
        int end=n-1;
        int ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){ 
                ans=mid;
                start=mid+1;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int upper=findupper(nums,target);
        int lower=findlower(nums,target);
        return new int[]{lower,upper};
    }
}