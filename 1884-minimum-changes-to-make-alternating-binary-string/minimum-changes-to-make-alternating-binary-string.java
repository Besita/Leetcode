class Solution {
   
    public int minOperations(String s) {
        int parity=0;
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)-'0'!=parity)
                count++;
            parity=1-parity;
        }
        
       return Math.min(count,n-count);
    }
}