class Solution {
    int prefixmaxsuffixmin(int[] arr){
       int n=arr.length;
       int chunks=0;

        int[] prefixmax=new int[n];
        prefixmax[0]=arr[0];
        for(int i=1;i<n;i++)
            prefixmax[i]=Math.max(prefixmax[i-1],arr[i]);

        int[] suffixmin=new int[n];
        suffixmin[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            suffixmin[i]=Math.min(suffixmin[i+1],arr[i]);

        for(int i=0;i<n;i++){
            if(i==0 || prefixmax[i-1]<suffixmin[i])
                chunks++;
        }
        return chunks;
    }
    
    public int maxChunksToSorted(int[] arr) {//prefixmax<suffixmin chunk++
        return prefixmaxsuffixmin(arr);

    }
}