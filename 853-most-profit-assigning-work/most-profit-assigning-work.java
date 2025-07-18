class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=difficulty.length;
        int[][] diff_prof=new int[n][2];
        for(int i=0;i<n;i++){
            diff_prof[i][0]=difficulty[i];
            diff_prof[i][1]=profit[i];
        }
        Arrays.sort(diff_prof,(a,b)->b[0]-a[0]);
        for(int i=n-2;i>=0;i--){
            diff_prof[i][1]=Math.max(diff_prof[i][1],diff_prof[i+1][1]);
        }
        Arrays.sort(worker);
        int i=worker.length-1;
        int j=0;
        int ans=0;
        while(i>=0 && j<n){
            if(worker[i]>=diff_prof[j][0]){
                ans+=diff_prof[j][1];
                i--;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}