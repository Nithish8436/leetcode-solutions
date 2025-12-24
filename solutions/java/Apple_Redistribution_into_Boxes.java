class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Step 1: Count total apples
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        // Step 2: Sort capacities descending
        Arrays.sort(capacity);
        
        // Step 3: Choose largest capacities
        int sum = 0;
        int count = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            sum += capacity[i];
            count++;
            if (sum >= totalApples) {
                return count;
            }
        }

        return count; // Should never hit here realistically
    }
}