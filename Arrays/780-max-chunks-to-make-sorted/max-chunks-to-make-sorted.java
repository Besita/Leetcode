class Solution {
    public int maxChunksToSorted(int[] arr) {//prefixmax<suffixmin chunk++
        int chunks=1;
        int n=arr.length;
        int[] prefixmax=new int[n];
        int[] suffixmin=new int[n];
        prefixmax[0]=arr[0];
        for(int i=1;i<n;i++)
            prefixmax[i]=Math.max(arr[i],prefixmax[i-1]);

        suffixmin[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            suffixmin[i]=Math.min(arr[i],suffixmin[i+1]);

        for(int i=1;i<arr.length;i++){
            if(prefixmax[i-1]<suffixmin[i])
                chunks++;
        }
        return chunks;
    }
}