class Solution {
    public boolean usingMethod1(String s,String t){
        Map<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else if(map.containsValue(t.charAt(i)) )
               return false;
            else
                map.put(s.charAt(i),t.charAt(i));
            
        }
        return true;
    }
   
    public boolean usingMethod2(String s,String t){
        int[] s1=new int[256];
        int[] t1=new int[256];
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(s1[ch1]!=t1[ch2])
                return false;
            s1[ch1]=i+1;
            t1[ch2]=i+1;
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {

        if(s.length()!=t.length())
            return false;

        //return usingMethod1(s,t);
        return usingMethod2(s,t); // SC:O(n1+n2) //fastest
        
    }
}