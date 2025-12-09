import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int MOD = (int)1e9 + 7;

        Map<Integer, Long> right = new HashMap<>();
        Map<Integer, Long> left = new HashMap<>();

        // Step 1: Count frequencies of all numbers on the right side
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }

        long total = 0;

        // Step 2: Move j from left to right
        for (int j = 0; j < n; j++) {
            int b = nums[j];

            // Remove nums[j] from right side (j is not counted in right)
            right.put(b, right.get(b) - 1);
            if (right.get(b) == 0) right.remove(b);

            long leftCount = left.getOrDefault(2 * b, 0L);
            long rightCount = right.getOrDefault(2 * b, 0L);

            total = (total + (leftCount * rightCount) % MOD) % MOD;

            // Add nums[j] to left side for further j positions
            left.put(b, left.getOrDefault(b, 0L) + 1);
        }
        return (int) total;
    }
}
