class Solution {
    
    public String largestWordCount(String[] messages, String[] senders) {
        int n=messages.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String[] word=messages[i].split(" ");
            map.put(senders[i],map.getOrDefault(senders[i],0)+word.length);
        }
       
        /*//Method 1 : TC: O(n log n)
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());

        Collections.sort(list,(a,b)-> { 
            if(b.getValue()==a.getValue())
                return b.getKey().compareTo(a.getKey());
            return b.getValue()-a.getValue();
        });
        
        return list.get(0).getKey();*/

        /*//Method 2:
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

        return largeWordName;*/

        //Method3:
        int largelen=0;
        String largeWordName="";
        for(String iter:map.keySet()){
            int currlen=map.get(iter);
            if(currlen>largelen || (currlen==largelen && iter.compareTo(largeWordName)>0)){
                largeWordName=iter;
                largelen=currlen;
            }
        }

        return largeWordName;
    }
}