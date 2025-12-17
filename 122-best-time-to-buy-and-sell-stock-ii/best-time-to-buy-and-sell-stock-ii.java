class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int Profit=0;
        int currMin=prices[0];
        for(int i=0;i<n;i++){
            if(prices[i]>currMin)
                Profit+=prices[i]-currMin;
                
            currMin=prices[i];
            
        }
        return Profit;
    }
}