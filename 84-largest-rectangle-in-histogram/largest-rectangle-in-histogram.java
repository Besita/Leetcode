class Solution {
    int[] smallerElementLeft(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            if(!st.isEmpty() && heights[st.peek()]<heights[i])  
                ans[i]=st.peek();
            st.push(i);
            //System.out.print(" "+ans[i]);
        }
        return ans;
    }
    int[] smallerElementRight(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,n);
        System.out.println();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            if(!st.isEmpty() && heights[st.peek()]<heights[i])  
                ans[i]=st.peek();
            st.push(i);    
            //System.out.print(" "+ans[i]);        
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nsel=smallerElementLeft(heights);
        int[] nser=smallerElementRight(heights);
        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,(nser[i]-nsel[i]-1)*heights[i]);
        }
        return maxArea;
    }
}