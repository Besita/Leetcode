class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        for(int[] i:pick){
            map.putIfAbsent(i[0],new HashMap<>());
            map.get(i[0]).put(i[1],map.get(i[0]).getOrDefault(i[1],0)+1);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> curr=map.get(i);
            if(curr!=null){
                for(int val:curr.values()){
                    if(val>i){ 
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;

    }
}