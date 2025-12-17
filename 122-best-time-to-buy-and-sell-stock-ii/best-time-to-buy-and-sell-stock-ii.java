class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int Profit=0;
        int currMin=prices[0];
        //if the numbers are in ascending order the previous solution works, max-min
        //here we should sell as soon as the price increases if the rices are random to get max profit

        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1])
                Profit+=prices[i]-prices[i-1];
        }
        return Profit;
    }
}