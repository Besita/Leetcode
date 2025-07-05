class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int[] lastseen=new int[26];
        int[] visited=new int[26];
        for(int i=0;i<n;i++)
            lastseen[s.charAt(i)-'a']=i;

        for(int i=0;i<26;i++)
            visited[i]=0;

        for(int i=0;i<n;i++){
            if(visited[s.charAt(i)-'a']==1)    continue;
            while(!st.isEmpty() && st.peek()>s.charAt(i) && i<lastseen[st.peek()-'a'] ){
                Character curr=st.peek();
                visited[curr-'a']=0;
                st.pop();
            }
            st.push(s.charAt(i));
            visited[s.charAt(i)-'a']=1;
        }
        int sz=st.size();
        String ans="";
        while(!st.isEmpty())
            ans=st.pop()+ans;

        return ans;
    }
}