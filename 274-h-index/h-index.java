class Solution {
    public int hIndex(int[] citations) {
        //since max value of h, sort the citations in decending order
        //sorting desc order,needs to convert int to wrapper object, to avoid it sort in ascending 
        //and iterate the index from n-1 to 0. 
        int n=citations.length;
        Arrays.sort(citations);
        int idx;
        int hidx=0;
        for(int i=n-1;i>=0;i--){      
            idx=n-i;      
            if(citations[i]>=idx) 
                hidx++;
        }
        return hidx;
    }
}