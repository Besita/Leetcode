class Solution {
    public int usingHeap(int[] stones){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones)
            pq.add(i);
        
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            int diff=x-y;
            if(diff>0)
                pq.add(diff);
        }
        if(pq.size()==1)
            return pq.poll();

        return 0;
    }
    public int usingArray(int[] stones){
        int n=stones.length;
        Arrays.sort(stones);        
        for(int i=n-1;i>0;i--){
            stones[i-1]=stones[i]-stones[i-1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
    public int lastStoneWeight(int[] stones) {

        //return usingHeap(stones);//TC:(n logn) SC:O(n)
        return usingArray(stones);//TC:O(n logn) SC:O(1)
        
    }
}