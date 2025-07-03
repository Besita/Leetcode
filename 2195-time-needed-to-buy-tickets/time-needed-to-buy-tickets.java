class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> pq=new LinkedList<>();
        int n=tickets.length;
        for(int i=0;i<n;i++)
            pq.add(i);

        int count=0;
        while(!pq.isEmpty()){
            int front=pq.poll();
            tickets[front]--;
            count++;

            if(tickets[front]==0 && front==k)
                return count;
            if(tickets[front] > 0)
                pq.add(front);
            
        }
        return -1;
    }
}