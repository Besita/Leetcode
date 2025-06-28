class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int win=p.length();
        int[] arr=new int[26];    
        int[] patt=new int[26];    
        for(int i=0;i<p.length();i++){
            patt[p.charAt(i)-'a']++;
        }

        int i=0,j=0;
        int winsize=0;
        List<Integer> ans=new ArrayList<>();
        while(j<n && i>=0){
            arr[s.charAt(j)-'a']++;
            winsize++;
            j++;
            if(winsize==p.length()){
                if(Arrays.equals(arr,patt))
                    ans.add(i);
                arr[s.charAt(i)-'a']--;
                winsize--;
                i++;
            }
        }
        return ans;
    }
}