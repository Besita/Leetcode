class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        if(n%3!=0)
            return new int[0][0];
        Arrays.sort(nums);
        List<int[]> ans=new ArrayList<>();
        int i=0;
        while(i<n){
            int a=nums[i];
            int b=nums[i+1];
            int c=nums[i+2];

            if(c-a>k)
                return new int[0][0];
                
            ans.add(new int[]{a,b,c});
            i+=3;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}