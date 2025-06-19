class Solution {
     public double myPow(double x, int n) {
        if(n==0)
            return 1d;
        //return bruteforce(x,n);
        return optimized(x,n);  
    }
    double bruteforce(double x,int n){
        int isneg=0;
        if(n<0){ 
            n=(n-(2*n));
            isneg=1;
        }
        
        double ans=x;
        for(int i=1;i<n;i++){
            ans*=x;
        }
        return (isneg==0)?ans:(1/ans);
    }
    double power(double x,int n){
        if(n==0)
            return 1d;
        if(n==1)
            return x;

        double ans=power(x,n/2);

        if(n%2==0)
            return ans*ans;
        return x*ans*ans;   
    }
    double optimized(double x,int n){
        if(n<0)
            return 1/(power(x,n-(2*n)));
        
        return power(x,n);
    }
   
    
}