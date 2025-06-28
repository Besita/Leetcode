class Solution {
    
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || t.length()>s.length())
            return "";
        if(s.equals(t))
            return s;
        int left=0;
        int right=0;
        int maxlen=s.length();
        String ans="";
        int[] map=new int[128];
        int[] patt=new int[128];

        for(Character i:t.toCharArray())
            patt[i]++;  
               
        for(right=0;right<s.length();right++){        
            map[s.charAt(right)]++;            
             
            if(compareTwoArray(map,patt)){
                do{                
                    map[s.charAt(left)]--;
                    left++;
                } while(compareTwoArray(map,patt));
                if(right-left+1 < maxlen){
                    maxlen=right-left+1;
                    ans=s.substring(left-1,right+1);
                }
            }
        }
        return ans;
    }
    public boolean compareTwoArray(int[] map,int[] patt){
        for(int i=0;i<patt.length;i++){
            if(map[i]<patt[i])         
                return false;
        }
        return true;
    }
}

