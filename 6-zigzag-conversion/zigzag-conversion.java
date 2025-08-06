class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] result=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++)
            result[i]=new StringBuilder();
        int row=0;
        int down=0;
        if(numRows==1)
            return s;
        for(int i=0;i<s.length();i++){
            result[row].append(s.charAt(i));
            System.out.println(result[row]);
            if(row==0)
                down=1;
            else if(row==numRows-1)
                down=0;

            if(down==1) row++;
            else    row--;
        }
        StringBuilder ans=new StringBuilder();
        for(StringBuilder i:result)
            ans.append(i);
        return ans.toString();
    }
}