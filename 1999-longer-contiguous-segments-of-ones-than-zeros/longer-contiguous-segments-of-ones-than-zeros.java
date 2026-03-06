class Solution {
    public boolean checkZeroOnes(String s) {
        int n=s.length();
        if(n==1){
            if(s.charAt(0)=='1')
                return true;
            return false;
        }
        int count0=0;
        int count1=0;
        int count=1;
        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);
            char prev=s.charAt(i-1);
            if(curr==prev){
                count++;
                if(curr=='0')
                    count0=Math.max(count0,count);
                else
                    count1=Math.max(count1,count);
            }else{
                count=1;                
            }
            System.out.println(curr+" "+count0+" "+count1);
        }
       
        if(count1>count0)
            return true;
        return false;
    }
}