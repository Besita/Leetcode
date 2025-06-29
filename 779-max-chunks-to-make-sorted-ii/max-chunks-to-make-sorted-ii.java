class Solution {
    int usingmaxprefixminsuffix(int[] arr){
        int n=arr.length;
        int[] maxprefix=new int[n];
        int[] minsuffix=new int[n];
        maxprefix[0]=arr[0];
        for(int i=1;i<n;i++)
            maxprefix[i]=Math.max(maxprefix[i-1],arr[i]);

        minsuffix[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            minsuffix[i]=Math.min(minsuffix[i+1],arr[i]);

        int ans=1;
        for(int i=1;i<n;i++){
            if(maxprefix[i-1]<=minsuffix[i])
                ans++;
        }
        return ans;
    }
    public int maxChunksToSorted(int[] arr) {
        return usingmaxprefixminsuffix(arr);
    }
}