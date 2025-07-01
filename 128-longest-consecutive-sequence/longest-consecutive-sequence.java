class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=1;
        if(n==1)
            return 1;
        if(n==0)
            return 0;
        int curr=1;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]==1){ 
                curr++;
                ans=Math.max(ans,curr);
            }
            else if(nums[i]==nums[i-1])
                continue;
            else{
                curr=1;

            }
        }
        return ans;
    }
}