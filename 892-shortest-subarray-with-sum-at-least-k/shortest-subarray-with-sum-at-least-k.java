class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new LinkedList<>();
        dq.offerLast(0);

        long[] prefix=new long[n+1];
        prefix[0]=0;
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        } 

        int count=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            while(!dq.isEmpty() && prefix[dq.peekLast()]>=prefix[i]){ 
               // System.out.println("polled from last");
                dq.pollLast();
            }
                        
            while(!dq.isEmpty() && prefix[i]-prefix[dq.peekFirst()]>=k){
                int window=i-dq.peekFirst();
                count=Math.min(window,count);
                dq.pollFirst();
                //System.out.println(window+"  "+"polled from front");
            }
            dq.offerLast(i);
            
        }
        return (count==Integer.MAX_VALUE)?-1:count;
    }
}