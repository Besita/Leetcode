class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int idx=0;
        Deque<Integer> dq=new LinkedList<>();
        
        for(int right=0;right<n;right++){
            //remove expired index outside window size
            while(!dq.isEmpty() && dq.peekFirst()<right-k+1)
                dq.pollFirst();

            //remove elements smaller than current val in the queue
            while(!dq.isEmpty() && nums[right]>=nums[dq.peekLast()])
                dq.pollLast();

            dq.offerLast(right);
            if(right>=k-1)
                ans[idx++]=nums[dq.peekFirst()];
        }
        return ans;
    }
}