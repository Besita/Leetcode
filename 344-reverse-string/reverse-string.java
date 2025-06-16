class Solution {
    public void swap(char[] s,int i,int j){        
        char k=s[i];
        s[i]=s[j];
        s[j]=k;
    }
    public void twoPointer(char[] s){
        int n=s.length;
        int low=0,high=n-1;
        while(low<=high){
            swap(s,low,high);
            low++;high--;
        }
    }
    public void usingStack(char[] s){
        Stack<Character> st=new Stack<>();
        for(char i:s){
            st.push(i);
        }
        for(int i=0;i<s.length;i++){
            s[i]=st.pop();
        }
    }
    public void usingBuildinFunction(char[] s){
        List<Character> arr=new ArrayList<>();
        for(char i:s)
            arr.add(i);

        Collections.reverse(arr);
        for(int i=0;i<s.length;i++)
            s[i]=arr.get(i);
    }
    public void usingRecursion(char[] s,int low,int high){
        if(low>=high)
            return;

        swap(s,low,high);
        usingRecursion(s,low+1,high-1);
    }
    public void reverseString(char[] s) {

        //twoPointer(s);//0ms
        //usingStack(s);//4ms
        //usingBuildinFunction(s);//2ms
        usingRecursion(s,0,s.length-1);//1 ms
    
    }
}