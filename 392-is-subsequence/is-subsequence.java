class Solution {
    public boolean stringCompare(String s,String t){
        int n1=t.length();
        int n2=s.length();
        int n2count=0;
        for(int i=0;i<n1 && n2count<n2;i++){ //O(n1+n2)=O(n)
            if(t.charAt(i)==s.charAt(n2count)){
                n2count++;
            }
        }
        if(n2count==n2)
            return true;
        return false;
    }
    public boolean twoPointer(String s,String t){
        int n=s.length();
        int m=t.length();
        if(m<n)
            return false;
        int i=0,j=0;
        while(i<n && j<m){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else
                j++;
        }
        if(i==n)
            return true;
        return false;
    }
    public boolean dynamicpgm(String s,String t,int idx,String curr){
        if(curr.length()>s.length())
            return false;
        System.out.println(curr);
        if(curr.equals(s)==true)
            return true;

        boolean take=false;
        if(curr.length()<s.length())
        take=dynamicpgm(s,t,idx+1,curr+t.charAt(idx));
        boolean nottake=dynamicpgm(s,t,idx+1,curr);

        return take||nottake;
    }
    public boolean isSubsequence(String s, String t) {
        //TC O(n+m) brute force approach
        //return stringCompare(s,t);
        //return dynamicpgm(s,t,0,"");
        return twoPointer(s,t);
        
    }
}
























