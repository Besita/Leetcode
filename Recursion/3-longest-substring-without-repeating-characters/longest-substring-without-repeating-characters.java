class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int maxlen=1;
        int n=s.length();
        if(n==0)
            return 0;        
        while(right<n && left<n){
            if(map.containsKey(s.charAt(right))==false){
                map.put(s.charAt(right),1);
                maxlen=Math.max(maxlen,right-left+1);
            }
            else{               
                while(s.charAt(left)!=s.charAt(right)){ 
                    map.remove(s.charAt(left));          
                    left++;    
                }
                left++;
            }
            right++;
        }
        return maxlen;
    }
}