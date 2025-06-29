class Solution {
    public boolean matches(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        if(n1>n2)   
            return false;

        int[] str1=new int[26];
        int[] str2=new int[26];

        for(int i=0;i<n1;i++){
            str1[s1.charAt(i)-'a']++;
            str2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(str1,str2))
            return true;
        //if(matches(str1,str2))
         //   return true;

        int start=0;
        for(int i=n1;i<n2;i++){
            str2[s2.charAt(i)-'a']++;
            str2[s2.charAt(start)-'a']--;
            start++;
            if(Arrays.equals(str1,str2))//if(matches(str1,str2))
                return true;
        }
        return false;    
    }   
    
}