class Solution {
    public double optimised(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int sz=m+n;
        if(m>n)
            return optimised(nums2,nums1);
        
        int low=0;
        int high=m;
        int l1,l2,r1,r2;
        while(low<=high){

            int mid1=(low+high)/2;
            int mid2=((sz+1)/2)-mid1;

            l1=Integer.MIN_VALUE;
            l2=Integer.MIN_VALUE;
            r1=Integer.MAX_VALUE;
            r2=Integer.MAX_VALUE;

            
            if(mid1-1>=0)
                l1=nums1[mid1-1];
            if(mid1<m)                
                r1=nums1[mid1];
            
            System.out.println(mid2-1);
            if(mid2-1>=0){ 
                System.out.println(nums2[mid2-1]);
                l2=nums2[mid2-1];
            }
            if(mid2<n)
                r2=nums2[mid2];

            if(l1<=r2 && l2<=r1){ 
                int l=Math.max(l1,l2);
                int r=Math.min(r1,r2);
                 if(sz%2==0)
                    return (l+r)/2.0;
                else
                    return l;
            }
            else if(l1>r2)
                high=mid1-1;
            else
                low=mid1+1;

        }
        return 0;
    }
    public double method3(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int tot=n+m;
        if(m<n)
            return method3(nums2,nums1);  //always choose low high mid with bigger array size
        
        int low=0;
        int high=m;
        int mid1,mid2;
        double ans=0;
        if(tot==0)
            return 0;
        while(low<=high){
            mid1=(low+high)/2;
            mid2=((tot+1)/2)-mid1;

            int l1=(mid1-1>=0)?nums1[mid1-1]:Integer.MIN_VALUE;
            int r1=(mid1<m)?nums1[mid1]:Integer.MAX_VALUE;

            System.out.println(mid2-1);
            int l2=(mid2-1>=0 && mid2-1<n)?nums2[mid2-1]:Integer.MIN_VALUE;
            int r2=(mid2<n)?nums2[mid2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                int l=Math.max(l1,l2);
                int r=Math.min(r1,r2);
                
                if(tot%2==0) //if size is even
                    return ans=(l+r)/2.0;
                else
                    return ans=l;
            }
            else if(l1>r2)
                high=mid1-1;
            else
                low=mid1+1;
        }
        return ans=0;
    }
    public double method2(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int arr1pointer=0;
        int arr2pointer=0;

        int sz=m+n;
        double median;
        int mid=sz/2;
        int odd=0; //if even median=(mid+(mid-1))/2
        if(sz%2==1){
            odd=1;
        }

        int anspointer=0;
        double ans=0.0;
        double curr=0.0;
        double prev=0.0;
        int cnt=0;
        while(arr1pointer<m && arr2pointer<n && cnt<=mid){
            prev=curr;
            if(nums1[arr1pointer]<=nums2[arr2pointer]){
                curr=nums1[arr1pointer++];
            }
            else{
                curr=nums2[arr2pointer++];
            }            
            cnt++;
            anspointer++;
        }
        while(arr1pointer<m && cnt<=mid){
            prev=curr;
            curr=nums1[arr1pointer++];
            cnt++;
            anspointer++;
        }
        while(arr2pointer<n && cnt<=mid){
            prev=curr;
            curr=nums2[arr2pointer++];        
            cnt++;   
            anspointer++;
        }
        if(odd==0)
            ans=(curr+prev)/2;
        else if(odd==1)
            ans=curr;

        return ans;
    }
    public double bruteforce(int[] nums1, int[] nums2) {
        //TC: O(n+m) SC: O(1)
        int m=nums1.length;
        int n=nums2.length;
        int arr1pointer=0;
        int arr2pointer=0;
        int[] ans=new int[m+n];
        int anspointer=0;
        while(arr1pointer<m && arr2pointer<n){
            if(nums1[arr1pointer]<=nums2[arr2pointer]){
                ans[anspointer++]=nums1[arr1pointer++];
            }
            else{
                ans[anspointer++]=nums2[arr2pointer++];
            }
        }
        while(arr1pointer<m){
            ans[anspointer++]=nums1[arr1pointer++];
        }
        while(arr2pointer<n){
            ans[anspointer++]=nums2[arr2pointer++];
        }

        int sz=m+n;
        double median;

        if(sz%2==0){
            int mid=sz/2;
            median=(ans[mid]+ans[mid-1])/2.0;
        }else{
            int mid=sz/2;
            median=ans[mid];
        }
        return median;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        return optimised(nums1,nums2);   //1ms beats 100%
        //return method3(nums1,nums2);  //1ms beats 100% 
        //return bruteforce(nums1,nums2);   //2ms        
    }
}