class Solution {
    public int optimised(String s,int k){
        int n=s.length();
        int left=0;
        int maxlen=0;
        int[] map=new int[26];
        int maxfreq=0;
        for(int right=0;right<n;right++){
            map[s.charAt(right)-'A']++;
            maxfreq=map[s.charAt(right)-'A'];
            int currwin=right-left+1;
            while((currwin-maxfreq) > k){
                map[s.charAt(left)-'A']--;
                left++;
                currwin--;
            }
            maxlen=Math.max(maxlen,currwin);
        }
        return maxlen; 
    }
    public int findmaxfreq(int[] freq){
        int maxfreq=0;
        for(int i=0;i<26;i++){
            maxfreq=Math.max(maxfreq,freq[i]);
        }
        return maxfreq;
    }
    public int usingfreqArray(String s,int k){
        int left=0;
        int n=s.length();
        int[] freq=new int[26];
        int maxlen=0;
        int maxfreq;
        for(int right=0;right<n;right++){
            freq[s.charAt(right)-'A']++;
            maxfreq=findmaxfreq(freq);
            while(right-left+1-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
                maxfreq=findmaxfreq(freq);
            }
            maxlen=Math.max(maxlen,right-left+1);  
        }
        return maxlen;
    }
    public int characterReplacement(String s, int k) {
        //return optimised(s,k);//TC:O(n) SC:O(n) 
        return usingfreqArray(s,k);
    }
}