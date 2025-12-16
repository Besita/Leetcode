class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sz=m+n-1;
        int a=m-1;
        int b=n-1;
        if(n==0)
            return;
        while(a>=0 && b>=0){
            if(nums1[a]>=nums2[b]){
                nums1[sz--]=nums1[a--];
            }
            else{
                nums1[sz--]=nums2[b--];
            }
        }
        while(b>=0){
            nums1[sz--]=nums2[b--];
        }
    }
}