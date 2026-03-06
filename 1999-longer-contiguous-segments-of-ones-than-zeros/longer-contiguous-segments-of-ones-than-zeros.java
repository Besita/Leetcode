class Solution {
    public boolean checkZeroOnes(String s) {
        int n=s.length();
        int count1=0,count0=0;
        if(s.charAt(0)=='1')
            count1++;
        else
            count0++;

        int count=1;
        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);
            char prev=s.charAt(i-1);
            if(curr==prev)
                count++;
            else
                count=1;                
            
            if(curr=='0')
                count0=Math.max(count0,count);
            else
                count1=Math.max(count1,count);
        }
       
        return (count1>count0);
    }
}