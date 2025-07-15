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
    public int maxProduct(int[] nums) {
        //return usingsort(nums); //TC:O(n log(n)) SC:O(1)
        return usingHeap(nums);  //TC:O(nlogn) SC:O(n)
    }
}