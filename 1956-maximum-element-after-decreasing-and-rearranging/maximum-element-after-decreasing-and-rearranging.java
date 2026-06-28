class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        int maxElem=1;
        Arrays.sort(arr);
        arr[0]=1;
        for(int i=1;i<n;i++){
            arr[i]=Math.min(arr[i-1]+1,arr[i]);
            maxElem=Math.max(arr[i],maxElem);
        }
        return maxElem;
    }
}