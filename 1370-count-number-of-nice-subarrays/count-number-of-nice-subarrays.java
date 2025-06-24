class Solution {
    public int optimized(int[] nums,int k){
         int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;
    }
    public int threepointer(int[] nums,int k){
        int left=0,mid=0,right=0;
        int n=nums.length;
        int odd=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1)
                odd++;            
            
            while(odd>k){
                if(nums[left]%2==1)
                    odd--;
                left++;
                mid=left;
            }

            if(odd==k){
                while(nums[mid]%2==0){
                    mid++;
                }
                ans+=mid-left+1;
            }            
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
       //return optimized(nums,k);
       return threepointer(nums,k);
    }
}