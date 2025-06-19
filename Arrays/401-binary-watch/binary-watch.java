class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans=new ArrayList<>();
        if(turnedOn>10)
            return new ArrayList<>();

        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn){
                    if(j<10)
                        ans.add(Integer.toString(i)+":0"+Integer.toString(j));
                    else
                        ans.add(Integer.toString(i)+":"+Integer.toString(j));
                }
            }
        }
        return ans;   
    }
}