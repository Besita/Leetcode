class Solution {
    public void backtracking(int k,int n,int curr,int sum,List<Integer> temp,List<List<Integer>> ans){
        if(k==0){ 
            if(sum==n)
                ans.add(new ArrayList(temp));
            return;
        }

        for(int i=curr;i<=9;i++){ 
            temp.add(i);
            backtracking(k-1,n,i+1,sum+i,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<>();
        backtracking(k,n,1,0,temp,ans);
        return ans;
    }
}