class Solution {
    public int hIndex(int[] citations) {
        //since max value of h, sort the citations in decending order
        int n=citations.length;
        Arrays.sort(citations);
        int idx;
        int hidx=0;
        for(int i=n-1;i>=0;i--){      
            idx=n-1-i;      
            if(citations[i]>idx)
                hidx++;
        }
        return hidx;
    }
}