
class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int totalsum=0;
        int minsum=INT_MAX,mincurrsum=0;
        int maxsum=INT_MIN,maxcurrsum=0;
        int n=nums.size();

        for(int i=0;i<n;i++){
            totalsum+=nums[i];
            mincurrsum+=nums[i];
            minsum=min(mincurrsum,minsum);
            if(mincurrsum>0)
                mincurrsum=0;

            maxcurrsum+=nums[i];           
            maxsum=max(maxcurrsum,maxsum);
            if(maxcurrsum<0)
                maxcurrsum=0;
        }

        if(totalsum==minsum)//corner case, all elements are negative, return maxsubarray
            return maxsum;
        return max(maxsum,totalsum-minsum);

        /*int curr_min=nums[0];
        int curr_max=nums[0];
        int global_max=nums[0];
        int global_min=nums[0];
        int total_sum=nums[0];
        int n=nums.size();
        for(int i=1;i<n;i++){
            total_sum+=nums[i];
            curr_max=max(curr_max+nums[i],nums[i]);
            curr_min=min(curr_min+nums[i],nums[i]);
            global_max=max(global_max,curr_max);
            global_min=min(global_min,curr_min); 
        }
        //cout<<global_max<<" "<<total_sum<<" "<<global_min;
        if(global_max>0)
            return max(global_max,total_sum-global_min);
            
        return global_max;  */      
    }
};