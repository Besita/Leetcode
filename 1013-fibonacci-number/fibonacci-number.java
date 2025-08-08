class Solution {
    public int recursion(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return (fib(n-1)+fib(n-2)); 
    }
    public int topdown(int n){
        int[] arr=new int[n+1];
        if(n<=1)
            return n;
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++)
            arr[i]=arr[i-1]+arr[i-2];
        return arr[n];        
    }
    public int fib(int n) {
        //return recursion(n);
        return topdown(n);
       
    }
}