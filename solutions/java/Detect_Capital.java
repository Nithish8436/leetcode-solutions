// class Solution {
//     public boolean detectCapitalUse(String word) {
//         int upper=0;

//         for(char ch:word.toCharArray())
//         {
//             if(ch>='A'&&ch<='Z')
//                upper++;
//         }
        
//         //the upper count and original word length are equal so it true
//         if(upper==word.length()) return true;

//         //if upper=0 we considered as the word is lower
//         if(upper==0) return true;

//         //to check that first letter is upper
//         if(upper==1&&word.charAt(0)>='A'&&word.charAt(0)<='Z') return true;


//        return false;
//     }
// }


class Solution {
    public boolean detectCapitalUse(String word) {
        int upper = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upper++;
            }
        }
        return upper == word.length()
            || upper == 0
            || (upper == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
