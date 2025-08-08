class Solution {
    public boolean method1(String str){
        Stack<Character> st=new Stack<>();
		for(int i=0;i<str.length();i++){
			char currstr=str.charAt(i);
			if(!st.isEmpty()){
				char curr=st.peek();
				if(currstr=='{' || currstr=='[' ||currstr=='(')
					st.push(currstr);
				else if(curr=='{' && currstr=='}')
					st.pop();
				else if(curr=='[' && currstr==']')
					st.pop();
				else if(curr=='(' && currstr==')')
					st.pop();
                else
                    return false;
			}else{
				if(currstr=='{' || currstr=='[' ||currstr=='(')
					st.push(currstr);
				else
					return false;
			}
				
		}
		if(st.isEmpty())
			return true;
		return false;
    }
    public boolean method2(String str){
        int n=str.length();
        Stack<Character> st=new Stack();
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{'){
                st.push(str.charAt(i));
            }
            else if(!st.isEmpty()){
                char curr=st.peek();
                if((curr=='(' && str.charAt(i)==')') || (curr=='[' && str.charAt(i)==']') || (curr=='{' && str.charAt(i)=='}'))
                    st.pop();
                else
                    return false;

            }
            else
                return false;
        }
        if(!st.isEmpty())
            return false;
        return true;

    }
    public boolean isValid(String str) {
        //return method1(str);
        return method2(str);
    }
}