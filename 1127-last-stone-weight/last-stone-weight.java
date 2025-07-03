class Solution {
    public int lastStoneWeight(int[] stones) {
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
}