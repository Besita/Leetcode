class Solution {
    public List<String> bruteforce(int turnedOn){
        List<String> ans=new ArrayList<>();
        if(turnedOn>10)
            return new ArrayList<>();

        for(int hour=0;hour<12;hour++){
            for(int min=0;min<60;min++){
                if(Integer.bitCount(hour)+Integer.bitCount(min)==turnedOn){
                    if(min<10)
                        ans.add(Integer.toString(hour)+":0"+Integer.toString(min));
                    else
                        ans.add(Integer.toString(hour)+":"+Integer.toString(min));
                }
            }
        }
        return ans; 
    }
    public List<String> readBinaryWatch(int turnedOn) {
          return bruteforce(turnedOn);//TC:O(12*60) SC:O(12*60)
    }
}