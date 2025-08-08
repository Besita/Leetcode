class Solution {
    public int soln(int[] prices){
        int n=prices.length;
        int maxprofit=0;
        int currlow=prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]<currlow)
                currlow=prices[i];
            maxprofit=Math.max(maxprofit,prices[i]-currlow);
        }
        return maxprofit;
    }
    public int maxProfit(int[] prices) {
        return soln(prices);
        /*int maxprofit=0;
        int n=prices.length;
        int currmin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){            
            currmin=Math.min(currmin,prices[i]);
            maxprofit=Math.max(maxprofit,prices[i]-currmin);
        }
        return maxprofit;*/
    }
}