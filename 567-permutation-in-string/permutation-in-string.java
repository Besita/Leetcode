class Solution {
    boolean checkPermutation(String str1,int[] temp){
        int n=str1.length();
        for(int i=0;i<n;i++){
            int ch=str1.charAt(i);
            if(temp[ch-'a']>0)
                temp[ch-'a']--;
            else
                return false;
        }
        for(int i=0;i<26;i++){
            if(temp[i]!=0)
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int winsize=s1.length();
        int m=s2.length();

        int[] arr=new int[26];
        for(int i=0;i<winsize;i++){
            char ch=s1.charAt(i);
            arr[ch-'a']++;
        }

        int[] temp=new int[26];

        for(int i=0;i<=m-winsize;i++){ 
            System.arraycopy(arr,0,temp,0,26);
            boolean isPresent=checkPermutation(s2.substring(i,i+winsize),temp);
            if(isPresent==true)
                return true;
        }
        return false;
    }
}