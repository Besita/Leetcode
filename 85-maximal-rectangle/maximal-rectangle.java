class Solution {
    int[] smallelementleft(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        System.out.println();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();            
            if(!st.isEmpty())
                ans[i]=st.peek();
            st.push(i);
            System.out.print(" "+ans[i]);
        }
        return ans;
    }
    int[] smallelementright(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length; 
        int[] ans=new int[n];
        Arrays.fill(ans,n);
        System.out.println();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();            
            if(!st.isEmpty())
                ans[i]=st.peek();
            st.push(i);
            System.out.print(" "+ans[i]);
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int[] arr=new int[matrix[0].length];
        int maxarea=0;
        int row=0;
        while(row<n){ 
            System.out.println();
            for(int col=0;col<matrix[0].length;col++){
                if(row==0)
                    arr[col]=(matrix[row][col]-'0');
                else{ 
                    if(matrix[row][col]-'0' == 0)
                        arr[col]=matrix[row][col]-'0';
                    else
                        arr[col]=arr[col]+matrix[row][col]-'0';  
                }
                System.out.print(" "+arr[col]);
            }
            int[] sel=smallelementleft(arr);
            int[] ser=smallelementright(arr);
            for(int i=0;i<matrix[0].length;i++){
                maxarea=Math.max(maxarea,(ser[i]-sel[i]-1)*arr[i]);
            }
            row++;
        }
        return maxarea;
    }
}