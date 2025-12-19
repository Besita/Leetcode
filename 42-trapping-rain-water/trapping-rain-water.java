class Solution {
    public int bruteforce(int []height){
         int n=height.length;
        int start=0;
        int end=n-1;
        int watertrapped=0;
        int[] trapped_left=new int[n];
        int[] trapped_right=new int[n];
        int max_left=0;
        int max_right=0;
        for(int i=0;i<n;i++){
            max_left=Math.max(max_left,height[i]);
            trapped_left[i]=max_left-height[i];
        }
        for(int i=n-1;i>=0;i--){
            max_right=Math.max(max_right,height[i]);
            trapped_right[i]=max_right-height[i];
        }
        for(int i=0;i<n;i++){
            watertrapped+=Math.min(trapped_left[i],trapped_right[i]);
        }
        
        return watertrapped; 
    }
    public int optimised(int []height){
         int n=height.length;
        int start=0;
        int end=n-1;
        int watertrapped=0;
        int max_left=0;
        int max_right=0;
        while(start<=end){
            if(height[start]<=height[end]){
                max_left=Math.max(max_left,height[start]);
                watertrapped+=max_left-height[start];
                start++;
            }
            else{
                max_right=Math.max(max_right,height[end]);
                watertrapped+=max_right-height[end];
                end--;
            }
        }
        return watertrapped; 
    }
    public int trap(int[] height) {
        return bruteforce(height);
        //return optimised(height);
    }
}