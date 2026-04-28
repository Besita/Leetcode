class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n==1)
            return 0;
        else if(n==2)
            return Math.abs(nums[0]-nums[1]);
        int maxVal=Integer.MIN_VALUE;
        int minVal=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            maxVal=Math.max(maxVal,nums[i]);
            minVal=Math.min(minVal,nums[i]);
        }        

        int bucketsize=Math.max(1,(maxVal-minVal)/(n-1));
        int bucketcount=(maxVal-minVal)/bucketsize+1;

        int[] minbucket=new int[bucketcount];
        Arrays.fill(minbucket,Integer.MAX_VALUE);
        int[] maxbucket=new int[bucketcount];
        Arrays.fill(maxbucket,Integer.MIN_VALUE);
        
        for(int i=0;i<n;i++){
            int idx=(nums[i]-minVal)/bucketsize;
            minbucket[idx]=Math.min(minbucket[idx],nums[i]);
            maxbucket[idx]=Math.max(maxbucket[idx],nums[i]);
        }
        int prev=minVal;
        int maxgap=0;
        for(int i=0;i<bucketcount;i++){
            if(minbucket[i]==Integer.MAX_VALUE) 
                continue;
            maxgap=Math.max(maxgap,minbucket[i]-prev);
            prev=maxbucket[i];
        }
        return maxgap;
    }
}