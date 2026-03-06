class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count1=0;
        int maxOnes=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){ 
                count1++;
            }
            else{
                count1=0;
            }
            maxOnes=Math.max(maxOnes,count1);
        }
        return maxOnes;
    }
}