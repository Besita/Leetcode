class Solution {
    public int hashmap(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int maxlen=1;
        int n=s.length();
        if(n==0)
            return 0;        
        for(right=0;right<n;right++){ //while(right<n && left<n){
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
        }
        return maxlen;
    }
    public int hashset(String s){
        HashSet<Character> set=new HashSet<>();
        int left=0;
        int right=0;
        int maxlen=1;
        int n=s.length();
        if(n==0)
            return 0;        
        while(right<n && left<n){
            if(set.contains(s.charAt(right))==false){
                set.add(s.charAt(right));
                maxlen=Math.max(maxlen,right-left+1);
            }
            else{               
                while(s.charAt(left)!=s.charAt(right)){ 
                    set.remove(s.charAt(left));          
                    left++;    
                }
                left++;
            }
            right++;
        }
        return maxlen;
    }
    public int usingarray(String s){
        int[] arr=new int[128];
        Arrays.fill(arr,0);
        int left=0;
        int right=0;
        int maxlen=1;
        int n=s.length();
        if(n==0)
            return 0;        
        while(right<n){
            if(arr[s.charAt(right)]==0){
                arr[s.charAt(right)]=1;
                maxlen=Math.max(maxlen,right-left+1);
            }
            else{               
                while(s.charAt(left)!=s.charAt(right)){ 
                    arr[s.charAt(left)]=0;          
                    left++;    
                }
                left++;
            }
            right++;
        }
        return maxlen;
    }
    public int lengthOfLongestSubstring(String s) {
        return hashmap(s);
        //return hashset(s); //4ms
        //return usingarray(s); //2ms
    }
}