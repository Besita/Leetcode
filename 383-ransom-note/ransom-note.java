class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ran=new int[26];
        int[] mag=new int[26];
        int n=ransomNote.length();
        int m=magazine.length();
        for(int i=0;i<n;i++){ 
            char ch=ransomNote.charAt(i);
            ran[ch-'a']++;
        }
        for(int i=0;i<m;i++){ 
            char ch=magazine.charAt(i);
            mag[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ran[i]>mag[i])
                return false;
        }
        return true;
    }
}