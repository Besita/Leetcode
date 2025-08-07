class Solution {
    public String longestCommonPrefix(String[] strs) {
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
}