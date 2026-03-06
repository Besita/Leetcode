class Solution {
    public boolean checkOnesSegment(String s) {
        int count=0;
        int n=s.length();
        int[] prefix=new int[n];
        prefix[0]=1;//there is no leading zeros
        if(prefix[0]==1)
            count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(prefix[i-1]==0)
                    count++;
                prefix[i]=prefix[i-1]+1;
            }else{
                prefix[i]=0;
            }
        }
        if(count>1)
            return false;
        return true;
    }
}