class Solution {
    public int soln(int[] prices){
        int n=prices.length;
        int maxProfit=0;
        int currMin=prices[0];
        for(int i=0;i<n;i++){
            if(prices[i]<currMin)
                currMin=prices[i];
            maxProfit=Math.max(maxProfit,prices[i]-currMin);
        }
        return maxProfit;
    }
    public int maxProfit(int[] prices) {
        return soln(prices);
       
    }
}