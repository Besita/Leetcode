class Solution {
    public int usingsort(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        return (nums[n-1]-1) * (nums[n-2]-1);
    }
    public int usingHeap(int[] nums){
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums)
            pq.add(i);

        return (pq.poll()-1) * (pq.poll()-1);
    }
    public int usingArray(int[] nums){
        int n=nums.length;
        int max1=0;
        int max2=0;
        for(int i:nums){
            if(i>max1){
                max2=max1;
                max1=i;
            }
            else if(i>max2){
                max2=i;
            }
        }
        return (max1-1) * (max2-1);
    }
    public int maxProduct(int[] nums) {
        return usingArray(nums);//TC:O(n) SC:O(1)
        //return usingsort(nums); //TC:O(n log(n)) SC:O(1) //2ms
        //return usingHeap(nums);  //TC:O(nlogn) SC:O(n) //3ms
    }
}