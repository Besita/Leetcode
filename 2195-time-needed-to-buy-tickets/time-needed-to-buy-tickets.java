class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> pq=new LinkedList<>();
        int n=tickets.length;
        for(int i=0;i<n;i++)
            pq.add(i);

        int count=0;
        while(!pq.isEmpty()){
            int temp=pq.poll();
            tickets[temp]--;
            count++;
            
            if(tickets[temp]==0 && temp==k)
                return count;
            if(tickets[temp] > 0)
                pq.add(temp);
            
        }
        return -1;
    }
}