class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            set.add(deadends[i]);
        }

        String curr="0000";
        if(set.contains(curr))
            return -1;
            
        Set<String> visited=new HashSet<>();
        visited.add(curr);
       
        Queue<String> q=new LinkedList<>();
        q.add(curr);
        //System.out.print(curr+" ");
        int moves=0;
        while(!q.isEmpty()){ 
            int sz=q.size();
            for(int k=0;k<sz;k++){ 
                curr=q.poll();
                //System.out.print(curr+","+moves+"  ");
                if(curr.equals(target))     return moves;
                for(int i=0;i<curr.length();i++){
                    //increment
                    char[] dummy=curr.toCharArray();
                    dummy[i]=(dummy[i]=='9')?'0':(char)(dummy[i]+1);
                    String incr=new String(dummy);
                    if(!set.contains(incr) && !visited.contains(incr)){
                        q.add(incr);
                        //System.out.print(incr+" ");
                        visited.add(incr);
                    }

                    //decrement
                    dummy=curr.toCharArray();
                    dummy[i]=(dummy[i]=='0')?'9':(char)(dummy[i]-1);
                    String decr=new String(dummy);
                    if(!set.contains(decr) && !visited.contains(decr)){
                        q.add(decr);
                        //System.out.print(decr+" ");
                        visited.add(decr);
                    }

                }
            }
            moves++;        
        }
        return -1;
    }
}