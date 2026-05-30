class Solution {
    public int findright(int[] nums,int target,int start,int end){
        int right=start;
        //System.out.println(start);
        //System.out.println(end);
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){ 
                right=mid;
                System.out.println(right);
                if(mid+1<end && nums[mid+1]!=target)  
                    return right;              
                start=mid+1;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return right;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        int curr=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){ 
                curr=mid;
                end=mid-1;
                if(mid-1>=0 && nums[mid-1]!=target)
                    break;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;

        }
        if(curr==-1)
            return new int[]{-1,-1};   

        int right=findright(nums,target,curr,n-1);
        return new int[]{curr,right};
    }
}