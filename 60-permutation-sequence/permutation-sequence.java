class Solution {
    public int factorial(int n){
        int ans=1;
        for(int i=1;i<=n;i++)
            ans*=i;
        return ans;
    }
    public String getPermutation(int n, int k) {
        StringBuilder input=new StringBuilder();
        for(int i=1;i<=n;i++)
            input.append(i);

        int index=k-1;//0th index        
        String ans="";

        while(input.length()>1){

            int fact=factorial(input.length()-1);
            ans+=input.charAt(index/fact);
            input.deleteCharAt(index/fact);
            index=index%fact;
        }

        ans+=input.charAt(0);
        return ans;
    }
}