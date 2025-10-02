class Pair{
    int val;
    int minval;
    Pair(int val,int minval){
        this.val=val;
        this.minval=minval;
    }
}
class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
            st.push(new Pair(val,val));
        else{
            Pair curr=st.peek();
            st.push(new Pair(val,Math.min(val,curr.minval)));
        }
    }
    
    public void pop() {
        if(st.isEmpty())
            return ;
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty())
            return -1;
        return st.peek().val;
    }
    
    public int getMin() {
        if(st.isEmpty())
            return -1;
        return st.peek().minval;        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */