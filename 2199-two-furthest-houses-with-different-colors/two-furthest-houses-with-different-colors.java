class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int maxdist=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Math.abs(colors[i]-colors[j])>0)
                    maxdist=Math.max(maxdist,j-i);
            }
        }
        return maxdist;
    }
}