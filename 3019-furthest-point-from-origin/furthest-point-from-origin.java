class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0,right=0,underscore=0;
        int furthest_dist=0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'L') 
                left++;
            else if (ch == 'R') 
                right++;
            else if (ch == '_') 
                underscore++;
        }
        
        furthest_dist+=Math.abs(left-right)+underscore;
        return furthest_dist;
    }
}