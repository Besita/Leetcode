class Solution {
    
    public String largestWordCount(String[] messages, String[] senders) {
        int n=messages.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String[] word=messages[i].split(" ");
            map.put(senders[i],map.getOrDefault(senders[i],0)+word.length);
        }
       
        /*//TC: O(n log n)
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());

        Collections.sort(list,(a,b)-> { 
            if(b.getValue()==a.getValue())
                return b.getKey().compareTo(a.getKey());
            return b.getValue()-a.getValue();
        });
        
        return list.get(0).getKey();*/

        int largeWord=0;
        String largeWordName="";
        for(Map.Entry<String,Integer> iter:map.entrySet()){
            if(iter.getValue()>largeWord){
                largeWordName=iter.getKey();
                largeWord=iter.getValue();
            }
            else if(iter.getValue()==largeWord){
                if(iter.getKey().compareTo(largeWordName)>0)
                    largeWordName=iter.getKey();
            }
        }

        return largeWordName;
    }
}