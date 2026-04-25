class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int unique=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }

        List<Integer> sortedKeys = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue()) // ascending by value
            .map(Map.Entry::getKey)
            .toList();

        //System.out.println(sortedKeys);
        for(Integer key:sortedKeys){
            if(k>0){ 
                k-=map.get(key);
                if(k>=0)
                    map.remove(key);
            }
            else
                break;
        }

        return map.size();
    }
}