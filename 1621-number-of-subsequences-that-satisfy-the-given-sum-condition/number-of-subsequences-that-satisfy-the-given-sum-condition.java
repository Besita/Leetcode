class Solution {
 
    public int numSubseq(int[] nums, int target) {

        /*int mod = 1000000007 , n = nums.length;
        Arrays.sort(nums);
        
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int left = 0 , right = n - 1 , result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;*/

        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int ans=0;
        int mod = 1000000007;
        int sum=0;
        int n=nums.length;
        int[] power=new int[nums.length];
        power[0]=1;
        for(int i=1;i<n;i++)
            power[i]=(power[i-1]*2)%mod;

        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans=(ans+power[right-left])%mod;
                left++;
            }
            else
                right--;
            
        }
        return ans;
    }
}
