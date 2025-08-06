class Solution {
    
    public String maxpalindromelength(String s,int mid1, int mid2, int n){
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
        if(n==1)
            return s;
        String ans=s.substring(0,1);
        for(int i=1;i<n;i++){
            String palinodd=maxpalindromelength(s,i,i,n);
            String palineven=maxpalindromelength(s,i-1,i,n);
            System.out.println(palinodd+","+palineven);
            if(palinodd.length()>ans.length())
                ans=palinodd;
            else if(palineven.length()>ans.length())
                ans=palineven;
        }
        return ans;
        //if(max_len==1)  
        //    return s.substring(0,0);
       // return (ans=="")?s.substring(0,1):ans;
    }
    
}