class Solution {
    public int arraymodified(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[Math.abs(nums[i])]<0)
                return Math.abs(nums[i]);
            nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
        }
        return -1;
    }
    public int slowfastapproach(int[] nums){
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
    public int findDuplicate(int[] nums) {
        //return arraymodified(nums);
        return slowfastapproach(nums);
    }
}