class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] newstr=s.split("\\s+");
        String reverse="";
        for(int i=newstr.length-1;i>=0;i--)
        {
           reverse=reverse+newstr[i];
           if (i > 0) {
                reverse += " ";
            }
        }

        return reverse;
    }
}