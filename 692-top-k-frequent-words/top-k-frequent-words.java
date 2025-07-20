class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String i:words){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair<Integer,String>> pq=new PriorityQueue<>((a,b)->{
            if(a.getKey()==b.getKey()) 
                return (a.getValue().compareTo(b.getValue()));
            return (b.getKey().compareTo(a.getKey()));
        });
        for(String i:map.keySet()){
            pq.add(new Pair(map.get(i),i));
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(pq.poll().getValue());
        }
        return ans;
        
    }
}