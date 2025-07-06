class Solution {
    void backtracking(int n,int open,int close,List<String> ans,String curr){
        if(open==n && close==n){
            ans.add(curr);
            return;
        }
        if(open<n){
            backtracking(n,open+1,close,ans,curr+"(");
        }
        if(close<open){
            backtracking(n,open,close+1,ans,curr+")");
        }
    

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backtracking(n,0,0,ans,"");
        return ans;
    }
}