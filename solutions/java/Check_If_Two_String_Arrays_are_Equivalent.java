class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1=word1.length;
        int n2=word2.length;
        String result="";
        for(int i=0;i<n1;i++)
        {
           result=result+word1[i];
        }

        String result2="";
        for(int i=0;i<n2;i++)
        {
            result2=result2+word2[i];
        }

        if(result.equals(result2))
        {
            return true;
        }
        return false;
    }
}