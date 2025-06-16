class Solution {
    public boolean Method1(String s,String t){
        int[] s1=new int[26];
        int[] t1=new int[26];
        for(int i=0;i<s.length();i++){
            char chS=s.charAt(i);
            char chT=t.charAt(i);
            s1[chS-'a']++;
            t1[chT-'a']++;
        }
        for(int i=0;i<26;i++){
            if(s1[i]!=t1[i])
                return false;
        }
        return true;
    }
    public boolean Method2(String s,String t){
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++)          
            arr[s.charAt(i)-'a']++;
            
        for(int i=0;i<t.length();i++)
            arr[t.charAt(i)-'a']--;
        
        for(int i=0;i<26;i++){
            if(arr[i]!=0)
                return false;
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        //return Method1(s,t);
        return Method2(s,t);
        
    }
}