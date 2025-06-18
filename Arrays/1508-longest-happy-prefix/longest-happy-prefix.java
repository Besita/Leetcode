class Solution {
    public String usingPrefix(String s){
        String ans="";
        int n=s.length();
        String[] prefix=new String[n];
        prefix[0]=s.substring(0,1);
        for(int i=1;i<n;i++)
            prefix[i]=s.substring(0,i+1);
        
        String[] suffix=new String[n];
        suffix[n-1]=s.substring(n-1,n);
        for(int i=n-2;i>=0;i--){
            suffix[i]=s.substring(i,n);
        }
        
        for(int i=n-2,j=1;i>=0;i--,j++){
            int out=prefix[i].compareTo(suffix[j]);
            //System.out.println(prefix[i]+" "+suffix[j]);
            if(out==0){ 
                System.out.println(prefix[i]+" "+suffix[j]);
                return prefix[i];
                //System.out.println(prefix[i]+" "+suffix[j]);
            }
        }
        return ans;
    }
    public String usingPrefixwithoutmemory(String s){
        String ans="";
        int n=s.length();
        for(int i=n-2,j=1;i>=0;i--,j++){ 
            String a=s.substring(0,i+1);
            String b=s.substring(j,n);
            if(a.compareTo(b)==0)
                return a;
        }
        return ans;
    }
    public String longestPrefix(String s) {
        //return usingPrefix(s);//TC:O(n) SC:O(n) //MLE error
        return usingPrefixwithoutmemory(s);
    }
}