class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> ans=new ArrayList<>();
        if(n==0){
            ans.add(newInterval);
            return ans.toArray(new int[ans.size()][]);
        }

        int i=0;   
            
            //No overlapping
        while(i<n && intervals[i][1]<newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        while(i<n && newInterval[1]>=intervals[i][0] ){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
                    
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
                    
        return ans.toArray(new int[ans.size()][]);
    }
}