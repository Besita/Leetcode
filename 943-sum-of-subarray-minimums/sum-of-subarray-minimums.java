class Solution {
    int[] MinElementLeft(
        int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(!st.isEmpty())
                ans[i]=st.peek();

            st.push(i);
            //System.out.print(" "+ans[i]);
        }
        return ans;
    }
    int[] MinElementRight(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans,n);
        //System.out.println();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
                st.pop();
            if(!st.isEmpty())
                ans[i]=st.peek();

            st.push(i);
           // System.out.print(" "+ans[i]);
        } 
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] leftmin=MinElementLeft(arr);
        int[] rightmin=MinElementRight(arr);
        long ans=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            int left=(i-leftmin[i])%mod;
            int right=(rightmin[i]-i)%mod;
            long inter=(long) (left*right)%mod;
            ans+=(inter * arr[i])%mod;
            ans%=mod;
        }
        return (int)ans;
    }
}