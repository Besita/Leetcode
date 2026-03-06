class Solution {
    public boolean checkOnesSegment(String s) {
        /*//Method1: TC:O(n) SC:O(1)
        int n=s.length();
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
        return true;*/

        //Method2: if string contains "01" then return false
        if(s.contains("01"))
            return false;
        return true;

    }
}