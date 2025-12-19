class Solution {
    public int usingHashMap(String s){
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n=s.length();
        int ans=0;
        //If a symbol is smaller than the one after it → subtract it. Otherwise → add it.
        char prev=' ';
        for(int i=n-1;i>=0;i--){
            char curr=s.charAt(i);
            if(i>0)
                prev=s.charAt(i-1);
            if(i>0 && map.get(prev) < map.get(curr)){
                ans+=map.get(curr)-map.get(prev);
                i--;
            }
            else{
                ans+=map.get(curr);
            }
        }
        return ans;
    }
    public int value(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
    public int usingSwitch(String s){
        int n=s.length();
        int ans=0;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(i>0 && value(ch)>value(s.charAt(i-1))){
                ans+=value(ch)-value(s.charAt(i-1));
                i--;
            }
            else
                ans+=value(ch);
        }
        return ans;
    }
    public int usingSwitch1(String s){
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
            if(i+1<n && value(s.charAt(i))<value(s.charAt(i+1))){
                res+=value(s.charAt(i+1))-value(s.charAt(i));
                i++;
            }
            else
                res+=value(s.charAt(i));
        }
        return res;
    }
    public int romanToInt(String s) {
        //TC:O(n) SC:O(n)
        return usingHashMap(s);
        //TC:O(n) SC:O(1)
        //return usingSwitch1(s);
    }
}