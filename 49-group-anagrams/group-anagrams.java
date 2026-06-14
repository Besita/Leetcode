class Solution {
    public boolean checkAnagram(String s,String t){
        if(s.length()!=t.length())
            return false;

        int[] arr=new int[26];           
        for(int i=0;i<t.length();i++){ 
            arr[t.charAt(i)-'a']--;
            arr[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(arr[i]!=0)
                return false;
        }
        return true;
    }
    public List<List<String>> usingBruteForce(String[] strs) {
        int n=strs.length;
        int[] str=new int[n];
        List<List<String>> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            List<String> curr=new ArrayList<>();
            if(str[i]==1)
                continue;
            str[i]=1;
            curr.add(strs[i]);
            for(int j=i+1;j<n;j++){
                if(str[j]==1)
                    continue;
                
                if(checkAnagram(strs[i],strs[j])){ 
                    str[j]=1;
                    curr.add(strs[j]);
                }
            }
            ans.add(curr);
        }
        return ans;
    }
    public List<List<String>> usingOptimisedHashmap(String[] strs) {
        int n=strs.length;
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] curr=strs[i].toCharArray();
            Arrays.sort(curr);
            String sortedString=new String(curr);
            if(!map.containsKey(sortedString)){                
                map.put(sortedString,new ArrayList<>());
            }
            map.get(sortedString).add(strs[i]);              
        }
        return new ArrayList<>(map.values());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        ///return usingBruteForce(strs);  //TC:534 ms
        return usingOptimisedHashmap(strs);
    }
}