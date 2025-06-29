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















        /*Map<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char orig=s.charAt(i);
            char repl=t.charAt(i);
            if(map.containsKey(orig)){  //if key present, if hashvalue and repl value differs fasle
                if(map.get(orig)!=repl)
                    return false;
            }
            else{
                if(map.containsValue(repl)) //if orig not present in key and repl not present in value add to map else false 
                    return false;
                else
                    map.put(orig,repl);
            }
        }
        return true;*/
    }
    public boolean usingMethod2(String s,String t){
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(!map1.containsKey(ch1))
                map1.put(ch1,i);

            if(!map2.containsKey(ch2))
                map2.put(ch2,i);
            
            if(!map1.get(ch1).equals(map2.get(ch2)))
                return false;
        }

        return true;
    }
    public boolean usingMethod3(String s,String t){
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

        return usingMethod1(s,t);

        //return usingMethod2(s,t); //SC:O(2*n1)

        //return usingMethod3(s,t); // SC:O(n1+n2) //fastest
        
    }
}