class Solution {   
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
        if(n==1)
            return s;
        for(int i=0;i<n;i++){
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