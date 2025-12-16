class Solution {
    int usingsort(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n/2];
    }
    int usingvoteralgo(int[] nums){
       // Arrays.sort(nums);
        int n=nums.length;
        int count1=0;
        int candidate1=0;
        for(int i=0;i<n;i++){
            if(count1==0){
                candidate1=nums[i];
                count1++;
            }
            else if(candidate1==nums[i])
                count1++;
            else
                count1--;
        }
        return candidate1;
    }
    public int majorityElement(int[] nums) {
        
        //return usingsort(nums); //TC:O(nlogn) SC:O(1)
        return usingvoteralgo(nums);//TC:O(n) SC:O(1)
    }
}