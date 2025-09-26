class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }

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
}