class Solution {
    void backtracking(int n,int curr,int k,List<List<Integer>> ans,List<Integer> temp){
        if(k==0){ 
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=curr;i<=n;i++){
            temp.add(i);
            backtracking(n,i+1,k-1,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<>();
        backtracking(n,1,k,ans,temp);
        return ans;
    }
}