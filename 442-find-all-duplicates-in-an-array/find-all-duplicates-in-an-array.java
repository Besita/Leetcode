class Solution {
    public List<Integer> Method1(int[] nums){
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int t=Math.abs(nums[i]);
            if(nums[t-1]<0)
                ans.add(t);
            nums[t-1]=-nums[t-1];
        }
        return ans;
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public List<Integer> Method2(int[] nums){
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        int i=0;
        while(i<n){
            if(nums[i]==i+1)
                i++;
            else if(nums[nums[i]-1]!=nums[i])//nums[i]!=i+1 && 
                swap(nums,i,nums[i]-1);
        }
        for(i=0;i<n;i++){
            if(nums[i]!=i+1)
                ans.add(nums[i]);
        }
        return ans;
    }
    public List<Integer> findDuplicates(int[] nums) {
        return Method1(nums);
        //return Method2(nums); //cyclic sort
        
    }
}