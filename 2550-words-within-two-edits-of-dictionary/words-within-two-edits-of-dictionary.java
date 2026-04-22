class Solution {
    public int compareString(String word1,String word2){
        int count=0;
        int n=word1.length();
        for(int i=0;i<n;i++){
            if(word1.charAt(i)!=word2.charAt(i))
                count++;
        }
        return count;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        int n=queries.length;
        int m=dictionary.length;
        for(int i=0;i<n;i++){
            String word1=queries[i];
            for(int j=0;j<m;j++){
                String word2=dictionary[j];
                int nn=compareString(word1,word2);
                if(nn<=2){
                    ans.add(word1);
                    break;
                }
            }
        }
        return ans;
    }
}