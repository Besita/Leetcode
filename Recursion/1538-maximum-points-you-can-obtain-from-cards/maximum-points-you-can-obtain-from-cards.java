class Solution {
    int findSum(int[] arr,int s,int e){
        int sum=0;
        for(int i=s;i<e;i++){
            sum+=arr[i];
        }
        return sum;
    }
    int bruteforce(int[] cardPoints,int k){
        int n=cardPoints.length;
        if(n==k){
            return Arrays.stream(cardPoints).sum();
        }
        int maxSum=0;
        int j=0;
        for(int i=0;i<=k;i++){
            int leftsum=findSum(cardPoints,0,i);
            int rightsum=findSum(cardPoints,n-k+j,n);
            maxSum=Math.max(maxSum,(leftsum+rightsum));
            j++;
        }
        return maxSum;
    }
    public int twopointer(int[] cardPoints,int k){
        int n=cardPoints.length;
        int right=n-k;
        int left=0;
        int lsum=0,rsum=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        int maxsum=lsum;                               
        for(int i=k-1,j=n-1;i>=0;i--,j--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[j];
            maxsum=Math.max(maxsum,lsum+rsum);
        }                                     
        return maxsum;                                                                                                                                                                                     
    }
    public int maxScore(int[] cardPoints, int k) {
       // return bruteforce(cardPoints,k); //TLE TC:O(k*k) SC: O(1)
        return twopointer(cardPoints,k);

        
    }
}