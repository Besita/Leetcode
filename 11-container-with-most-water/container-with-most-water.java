class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int maxcap=0;
        while(left<=right){
            maxcap=Math.max(maxcap,Math.min(height[left],height[right])*(right-left));
            if(height[left]<=height[right])
                left++;
            else
                right--;            
        }
        return maxcap;
    }
}