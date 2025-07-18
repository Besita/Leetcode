class Solution {
    public int usingSort(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int n=g.length;
        int m=s.length;
        int i=0;
        int j=0;
        int count=0;
        while(i<n && j<m){
            if(g[i]<=s[j]){
                i++;
                j++;
                count++;
            }
            else
                j++;
        }
        return count;
    }
    public int usingHeap(int[] g,int[] s){
        Arrays.sort(g);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:s)
            pq.add(i);

        int count=0;
        for(int i=0;i<g.length;i++){
            while(!pq.isEmpty()){
                if(g[i]<=pq.poll()){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public int findContentChildren(int[] g, int[] s) {
        return usingSort(g,s);//10ms
        //return usingHeap(g,s);//25ms
    }
}