class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n=barcodes.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[0]-a[0]));
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:barcodes){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        for(int i:map.keySet()){ 
            pq.add(new int[]{map.get(i),i});
           // System.out.println(map.get(i)+" "+i);
        }
        
        int[] ans=new int[n];
        int i=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int count=curr[0];
            while(curr[0]-- >0){
                if(i>=n) i=1;
                ans[i]=curr[1];
                i+=2;
            }
        }
        return ans;
    }
}