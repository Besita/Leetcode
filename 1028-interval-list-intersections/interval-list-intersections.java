class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int L1=firstList.length;
        int L2=secondList.length;       
        int i=0;
        int j=0;
        List<int[]> ans=new ArrayList<>();
        while(i<L1 && j<L2){
            if(firstList[i][0]<=secondList[j][1] && secondList[j][0]<=firstList[i][1]){
                int left=Math.max(firstList[i][0],secondList[j][0]);
                int right=Math.min(firstList[i][1],secondList[j][1]);
                ans.add(new int[]{left,right});
            }
            if(firstList[i][1]<secondList[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}