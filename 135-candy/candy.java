class Solution {
    public int optimized(int[] ratings){
        int n=ratings.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1] && ans[i]<=ans[i-1])
                ans[i]=ans[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && ans[i]<=ans[i+1])
                ans[i]=ans[i+1]+1;
        }
        int mincandy=0;
        for(int i:ans)
            mincandy+=i;

        return mincandy;
    }
    public int bruteforce(int[] ratings){
        int n=ratings.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] ans=new int[n];
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
                left[i]=left[i-1]+1;
            else
                left[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                right[i]=right[i+1]+1;
            else
                right[i]=1;
        }
        int mincandy=0;
        for(int i=0;i<n;i++){
            ans[i]=Math.max(left[i],right[i]);
            mincandy+=ans[i];
        }
        return mincandy;
    }
    public int candy(int[] ratings) {
        //return optimized(ratings);
        return bruteforce(ratings);
    }
}