class Solution {
    public int bruteForce(int[] colors){
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
    public int twopointer(int[] colors){
        int n=colors.length;
        int maxdist=Integer.MIN_VALUE;
        int start=0;
        int end=n-1;
        while(start<n){ ////don't work for testcase [6,6,6,6,6,6,6,6,6,19,19,6,6]
            if(colors[start]!=colors[end]){ 
                maxdist=Math.max(maxdist,end-start);
                break;
            }
            else
                start++;
        }
        start=0;
        end=n-1;
        while(end>=0){ ////don't work for testcase [6,6,19,19,6,6,6,6,6,6,6,6]
            if(colors[start]!=colors[end]){
                maxdist=Math.max(maxdist,end-start);
                break;
            }
            else
                end--;
        }
        return maxdist;
    }
    public int optimised(int[] colors){
        int n=colors.length;
        int maxdist=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[n-1]){ 
                maxdist=Math.max(maxdist,n-1-i);
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(colors[i]!=colors[0]){ 
                maxdist=Math.max(maxdist,i); //we need maxdist, so once you find distance break it, because other distancces will be less than this
                break;
            }
        }
        return maxdist;
    }
    public int maxDistance(int[] colors) {
        //return bruteForce(colors);
        return twopointer(colors); //don't work for testcase [6,6,6,6,6,6,6,6,6,19,19,6,6]
        //we need to calculate distancce from both sides instead of two pointer
        //return optimised(colors);
    }
}