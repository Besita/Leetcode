class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(a[0]-b[0]));
        int n=nums.length;

        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
            if(pq.size()>k)
                pq.poll();           
        }
        int[] ans=new int[k];
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<k;i++){
            int[] temp=pq.poll();
            set.add(temp[1]);
        }
        int p=0;
        for(int i=0;i<n;i++){
            if(set.contains(i)){
                ans[p++]=nums[i];
            }
        }
        return ans;
        
    }
}