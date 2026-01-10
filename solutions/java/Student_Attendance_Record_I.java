class Solution {
    public boolean checkRecord(String s) {
        int a=0,l=0;
        for(char ch:s.toCharArray())
        {
            if(ch!='L') l=0;
            if(ch=='A') a++;
            if(ch=='L') l++;
            if(a==2||l==3) return false;
            
        }
        return true;
    }
}