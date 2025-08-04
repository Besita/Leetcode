class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        //find min_subarray and max_subarray and total_sum. 
        //If total_sum==min_subarray then all elements in subarray are negative corner case, so return min_subarray,
        //else return max(total-min_subarray,max_subarray)

        int n=nums.length;
        int maxsum=Integer.MIN_VALUE;
        int minsum=Integer.MAX_VALUE;
        int mincurrsum=0;
        int maxcurrsum=0;
        int totsum=0;

        for(int i=0;i<n;i++){
            totsum+=nums[i];
            mincurrsum+=nums[i];
            minsum=Math.min(mincurrsum,minsum);
            if(mincurrsum>0)
                mincurrsum=0;

            maxcurrsum+=nums[i];
            maxsum=Math.max(maxcurrsum,maxsum);
            if(maxcurrsum<0)
                maxcurrsum=0;            
        }
        if(totsum==minsum)
            return maxsum;
        return Math.max(maxsum,totsum-minsum);
        /*int global_max=nums[0];
        int global_min=nums[0];
        int curr_min=nums[0];
        int curr_max=nums[0];
        int total_sum=nums[0];
        for(int i=1;i<nums.length;i++){
            curr_min=Math.min(curr_min+nums[i],nums[i]);
            curr_max=Math.max(curr_max+nums[i],nums[i]);
            global_max=Math.max(global_max,curr_max);
            global_min=Math.min(global_min,curr_min);
            total_sum+=nums[i];
        }
        if(global_max>0)
            return Math.max(global_max,total_sum-global_min);
        return global_max;*/
    }
}