class Solution {
    public int[][] usingTwoPointerMergeSort(int[][] firstList, int[][] secondList){
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
    public int[][] bruteforce(int[][] firstList, int[][] secondList){
        int L1=firstList.length;
        int L2=secondList.length;       

        Set<int[]> set=new HashSet<>();
        for(int i=0;i<L1;i++){
            for(int j=0;j<L2;j++){
                if(firstList[i][0]<=secondList[j][1] && secondList[j][0]<=firstList[i][1]){
                    int left=Math.max(firstList[i][0],secondList[j][0]);
                    int right=Math.min(firstList[i][1],secondList[j][1]);
                    set.add(new int[]{left,right});
                }
            }
        }
        int[][] ans=new int[set.size()][2];
        int i=0;
        for(int[] val:set){
            ans[i++]=val;
        }
        Arrays.sort(ans,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        return ans;
    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //return usingTwoPointerMergeSort(firstList,secondList); //3ms TC:O(n) SC:O(1)
        return bruteforce(firstList,secondList); 
        
    }
}