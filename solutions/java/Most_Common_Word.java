import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        
      
        String[] words = paragraph.split("\\s+");
    
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        
        String mostCommon = "";
        int maxCount = 0;

        for (int i = 0; i < words.length; i++) {
            String current = words[i];

           
            if (bannedSet.contains(current) || current.equals("")) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < words.length; j++) {
                if (current.equals(words[j])) {
                    count++;
                }
            }

     
            if (count > maxCount) {
                maxCount = count;
                mostCommon = current;
            }
        }

        return mostCommon;
    }
}
