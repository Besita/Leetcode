class Solution {
    public int value(char ch){
        switch(ch){
            case 'I':   return 1;
            case 'V':   return 5;
            case 'X':   return 10;
            case 'L':   return 50;
            case 'C':   return 100;
            case 'D':   return 500;
            case 'M':   return 1000;
            default:    return 0;
        }
    }
    public int romanToInt(String s) {
        int n=s.length();
        int result=0;
        for(int i=0;i<n;i++){
            if(i+1<n && value(s.charAt(i))<value(s.charAt(i+1))){
                result+=value(s.charAt(i+1))-value(s.charAt(i));
                i++;
            }
            else{
                result+=value(s.charAt(i));
            }
        }
        return result;
    }
}