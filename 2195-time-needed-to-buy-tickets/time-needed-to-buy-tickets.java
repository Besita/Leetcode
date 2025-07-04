class Solution {
    public int usingQueue(int[] tickets,int k){
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
    public int usingArray(int[] tickets,int k){
        int n=tickets.length;
        int count=0;
        while(tickets[k]>0){
            for(int i=0;i<n;i++){
                if(tickets[i]>0){
                    tickets[i]--;
                    count++;
                    if(tickets[i]==0 && i==k)
                        return count;
                }                
            }
        }
        return -1;
    }
    public int optimized(int[] tickets,int k){
        int n=tickets.length;
        int time=0;
        for(int i=0;i<n;i++){
            if(i<=k)
                time+=Math.min(tickets[i],tickets[k]);
            else
                time+=Math.min(tickets[i],tickets[k]-1);
        }
        return time;
    }
    public int timeRequiredToBuy(int[] tickets, int k) {
        //return usingQueue(tickets,k); //TC:O(nm) SC:O(n)
        //return usingArray(tickets,k); //TC:O(nm) SC:O(n)
        return optimized(tickets,k);//TC:O(n) SC:O(1)
    }
}