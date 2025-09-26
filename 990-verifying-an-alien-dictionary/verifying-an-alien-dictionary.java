class Solution {
    public boolean usingMap(String[] words,String order){
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++)
            map.put(order.charAt(i),i);

        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int l1=s1.length();
            int l2=s2.length();
            int k=0;
            int len=Math.min(s1.length(),s2.length());
            while(k<len && s1.charAt(k)==s2.charAt(k))
                k++;
            if(k<len){
                char c1=s1.charAt(k);
                char c2=s2.charAt(k);
                if(map.get(c1)>map.get(c2))
                    return false;
            }
            else if(l1>l2)
                return false;
        }
        return true;
    }
    public boolean usingArray(String[] words, String order) {
        int[] dict=new int[26];
        for(int i=0;i<order.length();i++){
            dict[order.charAt(i)-'a']=i;
        }

        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            int l1=s1.length();
            String s2=words[i+1];
            int l2=s2.length();
            int len=Math.min(l1,l2);
            int k=0;
            while(k<len && s1.charAt(k)==s2.charAt(k))
                k++;
            if(k<len){
                if(dict[s1.charAt(k)-'a']>dict[s2.charAt(k)-'a'])
                    return false;
            }
            else if(l1>l2)
                return false;
        }
        return true;
    }
    public boolean isAlienSorted(String[] words, String order) {
        //return usingMap(words,order);
        return usingArray(words,order);
        
    }
}