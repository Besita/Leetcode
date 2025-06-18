class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        if(n%3!=0)
            return new int[0][0];
        Arrays.sort(nums);
        List<int[]> ans=new ArrayList<>();
        int[] temp;
        int i=0;
        while(i<n){
            temp=new int[3];
            temp[0]=nums[i];
            temp[1]=nums[i+1];
            temp[2]=nums[i+2];

            if(temp[2]-temp[0]>k)
                return new int[0][0];
                
            ans.add(temp);
            i+=3;
        }
        return ans.toArray(new int[ans.size()][3]);
    }
}