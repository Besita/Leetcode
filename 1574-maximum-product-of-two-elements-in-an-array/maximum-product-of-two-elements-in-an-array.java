class Solution {
    public int usingsort(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        return (nums[n-1]-1) * (nums[n-2]-1);
    }
    public int maxProduct(int[] nums) {
        return usingsort(nums);
        //return usingHeap(nums);
    }
}