class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=nums[0];
        int n=nums.length;
        if(n==2)
            return nums;
        for(int i=1;i<n;i++)
            xor=xor^nums[i];

        int nums1=0;
        int nums2=0;
        for(int i=0;i<32;i++){
            if(((xor>>i)&1) == 1) {//if xor has a 1 bit, it can be used to divide the numbers o^1=1
                //System.out.print(i+" ");
                for(int j=0;j<n;j++){
                    //System.out.print(nums[j]+" ");
                    if(((nums[j]>>i)&1)==1)
                        nums1=nums1 ^ nums[j];
                    else
                        nums2=nums2 ^ nums[j];
                    //System.out.println(nums1+" "+nums2);
                }
            break;
            } 
        }
        return new int[]{nums1,nums2};
    }
}