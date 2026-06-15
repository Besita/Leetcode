class Solution {
    
    public String largestWordCount(String[] messages, String[] senders) {
        int n=messages.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String[] word=messages[i].split(" ");
            map.put(senders[i],map.getOrDefault(senders[i],0)+word.length);
        }

        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        
        Collections.sort(list,(a,b)-> { 
            if(b.getValue()==a.getValue())
                return b.getKey().compareTo(a.getKey());
            return b.getValue()-a.getValue();
        });

        return list.get(0).getKey();
    }
}