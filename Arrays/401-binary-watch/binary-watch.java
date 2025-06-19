class Solution {
    public List<String> bruteforce(int turnedOn){
        List<String> ans=new ArrayList<>();
        if(turnedOn>10)
            return new ArrayList<>();

        for(int hour=0;hour<12;hour++){
            for(int min=0;min<60;min++){
                if(Integer.bitCount(hour)+Integer.bitCount(min)==turnedOn){
                    if(min<10)
                        ans.add(hour+":0"+min);
                    else
                        ans.add(hour+":"+min);
                }
            }
        }
        return ans; 
    }
    public void backtracking(int turnedon,int curr,int hrs,int min,List<String> ans,int[] arr){
        if(turnedon==0){
            if(hrs<12 && min<60){
                if(min<10)
                        ans.add(hrs+":0"+min);
                    else
                        ans.add(hrs+":"+min);
            }
            return;
        }
        for(int i=curr;i<arr.length;i++){
            if(i<4)  hrs+=arr[i];
            else     min+=arr[i];

            backtracking(turnedon-1,i+1,hrs,min,ans,arr);

            if(i<4)  hrs-=arr[i];
            else     min-=arr[i];
        }
    }
    public List<String> readBinaryWatch(int turnedOn) {
        return bruteforce(turnedOn);//TC:O(12*60) SC:O(12*60)

        /*if(turnedOn>10)
            return new ArrayList<>();
        List<String> ans=new ArrayList<>();
        int[] arr={1,2,4,8,1,2,4,8,16,32};
        backtracking(turnedOn,0,0,0,ans,arr);//TC:O(2^n)
        return ans;*/
    }
}