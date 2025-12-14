class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int seats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') seats++;
        }

        // If seats are not divisible by 2, no valid division
        if (seats == 0 || seats % 2 != 0) return 0;

        long ways = 1;
        int seatCount = 0;
        int plantsBetween = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                // When a new section starts (after every 2 seats)
                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                    plantsBetween = 0;
                }
            } else if (seatCount >= 2 && seatCount % 2 == 0) {
                // Count plants between seat pairs
                plantsBetween++;
            }
        }

        return (int) ways;
    }
}
