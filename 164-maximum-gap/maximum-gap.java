class Solution {
    public int RadixSort(int[] nums) { 
        int n=nums.length;
        if(n==1)
            return 0;
        else if(n==2)
            return Math.abs(nums[0]-nums[1]);
        
        //find max element to find the no. of digits
        int maxVal=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxVal=Math.max(maxVal,nums[i]);
        }

        int exp=1; //1,10,100
        int[] output=new int[n];
    
        while(maxVal/exp>0){

            int[] bucket=new int[10];//should be inside loop to reset for each pass

            for(int i=0;i<n;i++){
                int val=(nums[i]/exp)%10;
                bucket[val]++;
            }

            for(int i=1;i<10;i++)
                bucket[i]+=bucket[i-1];

            for(int i=n-1;i>=0;i--){
                int val=(nums[i]/exp)%10;
                output[bucket[val]-1]=nums[i];
                bucket[val]--;
            }

            //nums=Arrays.copyOf(output,n);
            System.arraycopy(output,0,nums,0,n);
            exp=exp*10;
        }

        int maxdiff=0;
        for(int i=1;i<n;i++){
            maxdiff=Math.max(maxdiff,output[i]-output[i-1]);
        }
        return maxdiff;
    }
    public int BucketSort(int[] nums) { 
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
    public int maximumGap(int[] nums) {
        //return BucketSort(nums);//interviewer favorite.
        return RadixSort(nums);//easy sort 
        
    }
}