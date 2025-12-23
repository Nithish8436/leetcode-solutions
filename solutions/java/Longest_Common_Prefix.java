class Solution {
    public String longestCommonPrefix(String[] strs) {

         if (strs == null || strs.length == 0) 
            return "";

        StringBuilder sb=new StringBuilder();

        // Find the minimum length among all strings
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        for(int i=0;i<minLen;i++)
        {
            char ch=strs[0].charAt(i);

            for(int j=1;j<strs.length;j++)
            {
                if(ch!=strs[j].charAt(i))
                {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}