class Solution {
    public int findJudge(int n, int[][] trust) {
        int len=trust.length;
        int[] incoming=new int[n+1];
        int[] outgoing=new int[n+1];
    
        for(int i=0;i<len;i++){
            incoming[trust[i][1]]++;
            outgoing[trust[i][0]]++;
        }
        for(int i=1;i<=n;i++){
            if(incoming[i]==n-1 && outgoing[i]==0)
                return i;
        }
        return -1;
    }
}