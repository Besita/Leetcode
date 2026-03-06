class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        //int[] prefix=new int[n];
        int prefixsum=1;//there is no leading zeros
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(prefixsum==0)
                    return false;
                prefixsum++;
            }else{
                prefixsum=0;
            }
        }

        return true;
    }
}