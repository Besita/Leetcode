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

    public int usingarray1(String s){
        int left=0;
        int right=0;
        int n=s.length();
        if(n==0)
            return 0;
        int maxlen=1;
        int[] isunique=new int[128];
        Arrays.fill(isunique,0);
        for(right=0;right<n;right++){
            if(isunique[s.charAt(right)]==0){
                isunique[s.charAt(right)]=1;
                maxlen=Math.max(maxlen,right-left+1);
            }
            else{
                while(s.charAt(right)!=s.charAt(left)){
                    isunique[s.charAt(left)]=0;
                    left++;
                }
                left++;
            }
        }
        return maxlen;
    }






    public int usingarray2(String s){
        int[] arr=new int[128];
        int n=s.length();
        if(n<=1)
            return n;
        int maxlen=0;
        int left=0;
        for(int right=0;right<n;right++){
            if(arr[s.charAt(right)]==0){
                arr[s.charAt(right)]=right+1;
                maxlen=Math.max(maxlen,right-left+1);
            }
            else{
                while(arr[s.charAt(left)]!=arr[s.charAt(right)]){ 
                   arr[s.charAt(left)]=0;
                   left++;
                }
                left++;
            }
            //System.out.println(left+" "+right+" "+maxlen);
        }
        return maxlen;
    }

    public int lengthOfLongestSubstring(String s) {
        //return hashmap(s); //5ms
        //return hashset(s); //4ms
        return usingarray2(s); //2ms
    }
}