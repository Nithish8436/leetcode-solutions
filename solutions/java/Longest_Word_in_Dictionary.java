class Solution {
    public String longestWord(String[] words) {
        int n=words.length;
        if(words.length==0)
        {
            return "";
        }

        Set<String> set=new HashSet<>(Arrays.asList(words));

        String result="";


        for(String word:words)
        {
            boolean valid=true;
            for(int i=1;i<word.length();i++){
               if(!set.contains(word.substring(0,i)))
               {
                  valid=false;
                  break;
               }
            }


            if(valid)
            {
                if(word.length()>result.length()||word.length()==result.length()&&word.compareTo(result)<0)
                {
                    result=word;
                }
            }
        }
        return result;

    }
}