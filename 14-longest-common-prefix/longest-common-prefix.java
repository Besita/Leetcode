class Solution {
    public String method1(String[] strs){
        Arrays.sort(strs);
        int n=strs.length;
        int itr=strs[0].length();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<itr;i++){
            int comp=1;
            char ch=strs[0].charAt(i);
            for(int j=1;j<n;j++){
                if(strs[j].charAt(i)!=ch)
                    comp=0;
            }
            if(comp==0)
                break;
            else
                ans.append(strs[0].charAt(i));
        }
        return ans.toString();
    }
    public String method2(String[] strs){
        int n=strs.length;
        int itr=strs[0].length();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<itr;i++){  // flower
            for(int j=1;j<n;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=strs[0].charAt(i)) { 
                    return ans.toString();
                }
            }
            ans.append(strs[0].charAt(i));
        }
        return ans.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        //return method1(strs);
        return method2(strs);
    }
}