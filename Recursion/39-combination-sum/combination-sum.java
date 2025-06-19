class Solution {
    public void backtracking(int[] candidates,int n,int curr,int target,List<Integer> temp,List<List<Integer>> ans){
        if(target<=0 || curr>=n){
            if(target==0)
                ans.add(new ArrayList(temp));
            return;
        }

        temp.add(candidates[curr]);
        backtracking(candidates,n,curr,target-candidates[curr],temp,ans);//include
        temp.remove(temp.size()-1);
        backtracking(candidates,n,curr+1,target,temp,ans);//exclude
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<>();
        int n=candidates.length;
        backtracking(candidates,n,0,target,temp,ans);
        return ans;
    }
}