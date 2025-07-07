class Solution {
    public int usingBruteForce(long n){
        long odddigit=n/2;
        long evendigit=(n+1)/2;;
        int mod=1000000007;
        long ans=1;
        for(long i=0;i<n;i++){
            if((int)i%2==0){
                ans=(ans%mod * 5%mod)%mod;
            }else{
                ans=(ans%mod * 4%mod)%mod;
            }
        }
        return (int)ans%mod;
    }
    long fastPower(int num,long power){
        if(power==0)
            return 1L;
        if(power==1)
            return num;
        int mod=1000000007;

        long ans=fastPower(num,power/2);

        if(power%2==0)
            return (ans * ans)%mod;
        
        return  (num * ans * ans)%mod;

    }
    int optimized(long n){
        if(n==1)
            return 5;
        int mod=1000000007;

        long odd=n/2;
        long even=(n+1)/2;        
        long evenidx = fastPower(5,even);
        long oddidx = fastPower(4,odd);

        return (int)((evenidx * oddidx) %mod);

    }
    public int countGoodNumbers(long n) {
        //return usingBruteForce(n);//TC:O(n) n>=10^15
        return optimized(n);

        
    }
}