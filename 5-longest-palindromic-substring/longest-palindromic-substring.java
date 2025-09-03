class Solution {
    
    /*public String maxpalindromelength(String s,int mid1, int mid2, int n){
        int left=mid1;
        int right=mid2;
        while(left>=0 && right<n){
            if(s.charAt(left)==s.charAt(right)){ 
                left--;right++;
            }
            else
                break;
        }
        return s.substring(left+1,right);
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        String ans="";
        for(int i=1;i<n;i++){
            String palinodd=maxpalindromelength(s,i,i,n);
            if(palinodd.length()>ans.length())
                ans=palinodd;
            String palineven=maxpalindromelength(s,i-1,i,n);
            if(palineven.length()>ans.length())
                ans=palineven;
        }
        if(ans.length()==0)
            ans=s.substring(0,1);
        return ans;
    }*/











    public String maxpalin(String s,int left,int right){
        int n=s.length();
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    public String longestPalindrome(String s) {
        int n=s.length();
        String ans="";
        int maxlen=0;
        if(n<=1)
            return s;
        for(int i=0;i<n-1;i++){
            String odd=maxpalin(s,i,i);
            if(odd.length()>ans.length())
                ans=odd;
            
            String even=maxpalin(s,i,i+1);
            if(even.length()>ans.length())
                ans=even;
        }
        return ans;
    }
}