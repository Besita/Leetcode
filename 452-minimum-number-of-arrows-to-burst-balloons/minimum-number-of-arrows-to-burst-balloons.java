class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int count=0;
        int n=points.length;
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int start=points[i][0];
            int end=points[i][1];
            while(i+1<n && points[i+1][0]<=end){
                start=Math.max(start,points[i+1][0]);
                end=Math.min(end,points[i+1][1]);
                i++;
            }
            count++;
            ans.add(new int[]{start,end});
        }
        return count;
    }
}