class Solution {
    public int trap(int[] height) {
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
}