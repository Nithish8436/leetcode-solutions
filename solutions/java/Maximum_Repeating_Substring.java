// class Solution {
//     public int maxRepeating(String sequence, String word) {
//         int n=sequence.length();
//         int count=0;
//         String result=word;

//         while(sequence.contains(word))
//         {
//            count++;
//            result+=word;

//         }

//         return count;
//     }
// }


// class Solution {
//     public int maxRepeating(String sequence, String word) {
//         int maxCount = 0;
//         int wordLen = word.length();

//         for (int i = 0; i <= sequence.length() - wordLen; i++) {
//             int count = 0;
           
//             while (i + wordLen <= sequence.length() &&
//                    sequence.substring(i, i + wordLen).equals(word)) {
//                 count++;
//                 i += wordLen; 
//             }
//             maxCount = Math.max(maxCount, count);
//         }

//         return maxCount;
//     }
// }

class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder repeated = new StringBuilder(word);

        while (sequence.indexOf(repeated.toString()) != -1) {
            count++;
            repeated.append(word);
        }

        return count;
    }
}

