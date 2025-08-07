class Solution {
    public int method1(String s){
        int n=s.length();

        //edge case:
        if(n==0)
            return 0;
        //step1:check whitespace
        int i=0;
        long res=0;
        int sign=1;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        //step2:check for sign
        if(i<n && s.charAt(i)=='+')
            i++;
        else if(i<n && s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        
        //step3: convert digit to int 
        while(i<n && (s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)){
            res=(res*10)+(s.charAt(i)-'0');
            i++;

            if(res*sign>=Integer.MAX_VALUE) 
                return Integer.MAX_VALUE;
            else if(res*sign<=Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        
        
        return (int)(sign*res);

    }
    public int myAtoi(String s) {
        return method1(s);
    }
}