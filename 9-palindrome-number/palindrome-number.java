class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int orig=x;
        int ans=0;
        while(x>0){
            int rem=x%10;
            ans=ans*10+rem;
            x=x/10;
        }
        //System.out.println(x+" "+ans);
        if(orig==ans)
            return true;
        return false;
    }
}