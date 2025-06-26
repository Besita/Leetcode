class Solution {
    public String winningPlayer(int x, int y) {
        int xval=x/1;
        int yval=y/4;
        int ans=Math.min(xval,yval);
        if(ans%2==1)
            return "Alice";
        return "Bob";
    }
}