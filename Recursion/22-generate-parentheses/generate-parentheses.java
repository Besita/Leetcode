class Solution {
    void generate(int open,int close,StringBuilder str,List<String> ans){
        if(open==0 && close==0){ 
            ans.add(str.toString());
            return;
        }

        if(open>0){ 
            str.append('(');
            generate(open-1,close,str,ans);
            str.deleteCharAt(str.length()-1);
        }
        
        if(close>open){ 
            str.append(')');
            generate(open,close-1,str,ans);
            str.deleteCharAt(str.length()-1);
        }        
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        generate(n,n,str,ans);
        return ans;
    }
}