class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            while(i+1<n && intervals[i+1][0]<=end){
                end=Math.max(end,intervals[i+1][1]);
                i++;
            }
            ans.add(new int[]{start,end});
        }
        return ans.toArray(new int[ans.size()][2]);
        
    }
}










/*int prev_start=intervals[0][0];
        int prev_end=intervals[0][1];
        List<int[]> ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=prev_end){
                prev_start=Math.min(prev_start,intervals[i][0]);
                prev_end=Math.max(prev_end,intervals[i][1]);
            }
            else{
                ans.add(new int[]{prev_start,prev_end});
                prev_start=intervals[i][0];
                prev_end=intervals[i][1];
            }
        }
        ans.add(new int[]{prev_start,prev_end});
        return ans.toArray(new int[ans.size()][]);*/









