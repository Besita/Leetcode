class Solution {
    public String removeDuplicateLetters(String s) {
        String ans="";
        Stack<Character> st=new Stack<>();
        int[] lastseen=new int[26];
        int[] visited=new int[26];
        for(int i=0;i<s.length();i++)
            lastseen[s.charAt(i)-'a']=i; 

        for(int i=0;i<26;i++)
            visited[i]=0;

        for(int i=0;i<s.length();i++){
            if(visited[s.charAt(i)-'a']==1)    continue;
            while(!st.isEmpty() && st.peek()>s.charAt(i) && i<lastseen[st.peek()-'a']){ 
                Character temp=st.peek();
                visited[temp-'a']=0;
                st.pop();               
            }        
            st.push(s.charAt(i));   
            visited[s.charAt(i)-'a']=1;       
            
        }
        int arrlen=st.size();
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }       
        return ans;
    }
}