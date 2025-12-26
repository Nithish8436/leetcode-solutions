class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        
        // Initial penalty: shop closed all day
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        // Try closing at each hour
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--; // now served, no penalty
            } else {
                penalty++; // open with no customers
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}