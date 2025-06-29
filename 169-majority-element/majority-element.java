class Solution {
    int usingsort(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n/2];
    }
    int usingvoteralgo(int[] nums){
        Arrays.sort(nums);
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
        //using sort
        //return usingsort(nums);
        return usingvoteralgo(nums);

       /* int n=nums.length;
        int count=0;
        int candidate=0;
        for(int i=0;i<n;i++){
            if(count==0){
                candidate=nums[i];
                count++;
            }
            else{
                if(candidate==nums[i])
                    count++;
                else
                    count--;
            }
        }
        return candidate;*/
    }
}