class Solution {
    public int usingSortgreedy(int[] difficulty, int[] profit, int[] worker) {
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
    public int usingMemoization(int[] difficulty, int[] profit, int[] worker) {
        int maxval=0;
        for(int i=0;i<difficulty.length;i++)
            maxval=Math.max(maxval,difficulty[i]);
        
        for(int i=0;i<worker.length;i++)
            maxval=Math.max(maxval,worker[i]);

        int[] memo=new int[maxval+1];
        for(int i=0;i<difficulty.length;i++){
            memo[difficulty[i]]=Math.max(memo[difficulty[i]],profit[i]);
        }

        int maxsofar=0;
        for(int i=0;i<=maxval;i++){            
            maxsofar=Math.max(maxsofar,memo[i]);//updatemaxsofar
            memo[i]=maxsofar;
        }
        int maxprofit=0;
        for(int i=0;i<worker.length;i++){
            maxprofit+=memo[worker[i]];
        }
        return maxprofit;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //return usingSortgreedy(difficulty,profit,worker);
        return usingMemoization(difficulty,profit,worker);
    }
}