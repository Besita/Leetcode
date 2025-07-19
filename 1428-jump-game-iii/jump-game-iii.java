class Solution {
    public boolean usinglevelorder(int[] arr,int start,int min,int max){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int val=q.poll();
                if(arr[val]==0) return true;
                if(arr[val]<0) continue;
                if(val+arr[val]<max){ 
                    q.add(val+arr[val]);
                }
                if(val-arr[val]>=min){ 
                    q.add(val-arr[val]);
                }
                arr[val]*=-1;
            }
        }
        return false;
    }
    public boolean canReach(int[] arr, int start) {
        return usinglevelorder(arr,start,0,arr.length);
    }
}