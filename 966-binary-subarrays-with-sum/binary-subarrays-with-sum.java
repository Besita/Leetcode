
class Solution {
    int slidingwindow(int[] nums,int goal){
        int left=0;
        int ans=0;
        int sum=0;
        if(goal<0)
            return 0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            if(sum<=goal)
                ans+=right-left+1;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return slidingwindow(nums,goal)-slidingwindow(nums,goal-1);
    }
}