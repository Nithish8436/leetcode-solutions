class Solution {
    public String truncateSentence(String s, int k) {
        String[] str=s.split(" ");
        String newstr="";
        for(int i=0;i<k;i++)
        {
            newstr=newstr+" "+str[i];
        }
        return newstr.trim();
    }
}