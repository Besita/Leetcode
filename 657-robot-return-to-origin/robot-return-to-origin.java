class Solution {
    public boolean judgeCircle(String moves) {
        int originr=0;
        int originc=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L')
                originc--;
            else if(moves.charAt(i)=='R')
                originc++;
            else if(moves.charAt(i)=='U')
                originr--;
            else
                originr++;  
        }
        return (originr==0 && originc==0);
    }
}