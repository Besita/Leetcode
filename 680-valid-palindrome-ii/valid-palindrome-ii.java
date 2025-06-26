class Solution {
    boolean ispalindrome(String s){
        System.out.println(s);
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }
            else
                return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n=s.length();
        int l=0,r=n-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){ 
                if(ispalindrome(s.substring(0,l)+s.substring(l+1)) || ispalindrome(s.substring(0,r)+s.substring(r+1)) )
                    return true;
                return false;
            }
            else{ 
                l++;
                r--;
            }
        }
        return true;
    }
}