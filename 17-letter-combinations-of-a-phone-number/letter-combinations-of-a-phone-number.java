class Solution {
    public void backtrack(int idx,int n,List<String> ans,StringBuilder temp,String[] letters,String digits) {
        if(idx==n){
            ans.add(temp.toString());
            return;
        }

        String curr=letters[digits.charAt(idx)-'0'];
        for(int i=0;i<curr.length();i++){
            temp.append(curr.charAt(i));
            backtrack(idx+1,n,ans,temp,letters,digits);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        /*String[] letters=new String[10];
        letters[0]="";
        letters[1]="";
        letters[2]="abc";
        letters[3]="def";
        letters[4]="ghi";
        letters[5]="jkl";
        letters[6]="mno";
        letters[7]="pqrs";
        letters[8]="tuv";
        letters[9]="wxyz";*/

        String[] letters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> ans=new ArrayList<>();
        int n=digits.length();
        if(n==0)
            return ans;
        StringBuilder temp=new StringBuilder();
        backtrack(0,n,ans,temp,letters,digits);     
        return ans;   

    }
}