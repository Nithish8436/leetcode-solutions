class Solution {
    public String reverseWords(String s) {
        String[] newstr=s.split("\\s+");
        String reverse="";
        for(int i=newstr.length-1;i>=0;i--)
        {
           reverse=reverse+" "+newstr[i];
        }

        return reverse.trim();
    }
}