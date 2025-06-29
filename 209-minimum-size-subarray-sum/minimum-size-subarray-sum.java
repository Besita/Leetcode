class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int end=0;
        int start=0;
        int currsum=0;
        int minlen=Integer.MAX_VALUE;
        //int minsum=Integer.MAX_VALUE;
        for(end=0;end<n;end++){
            currsum+=nums[end];
            while(currsum>=target){           
                //minsum=Math.min(minsum,currsum);
                minlen=Math.min(minlen,end-start+1);
                currsum-=nums[start];
                start++;
            }
        }
        if(minlen==Integer.MAX_VALUE)
            return 0;
        return minlen;


        
        /*//TC O(n) SC:O(1)
        int n=nums.length;
        int end=0;
        int start=0;
        int currsum=0;
        int minlen=Integer.MAX_VALUE;
        int minsum=Integer.MAX_VALUE;
        for(end=0;end<n;end++){
            currsum+=nums[end];
            if(currsum>=target){ 
                break;
            }
        }
        while(start<n && end<n){
            if(currsum>=target){                
                minsum=Math.min(minsum,currsum);
                minlen=Math.min(minlen,end-start+1);
                currsum-=nums[start];
                start++;
            }else{
                end++;
                if(end>=n)
                    break;
                currsum+=nums[end];
            }
        }
        if(minlen==Integer.MAX_VALUE)
            return 0;
        return minlen;*/
    }
}