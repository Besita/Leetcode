class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int result=0,count;
        for(int i=0;i<32;i++){
            count=0;
            for(int j=0;j<n;j++){
                count+=(nums[j]>>i)&1;
            }
            if(count%3==1)
                result=result | (1<<i);
        }
        return result;        
    }
}