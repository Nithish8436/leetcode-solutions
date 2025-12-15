class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;

        // Store min and max Y for each row
        int[] minY = new int[n + 1];
        int[] maxY = new int[n + 1];

        // Store min and max X for each column
        int[] minX = new int[n + 1];
        int[] maxX = new int[n + 1];

        // Initialize arrays
        Arrays.fill(minY, Integer.MAX_VALUE);
        Arrays.fill(minX, Integer.MAX_VALUE);

        // Step 1: Compute min/max in each row and column
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            minY[x] = Math.min(minY[x], y);
            maxY[x] = Math.max(maxY[x], y);

            minX[y] = Math.min(minX[y], x);
            maxX[y] = Math.max(maxX[y], x);
        }

        int covered = 0;

        // Step 2: Check conditions for each building
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            boolean left  = minY[x] < y;
            boolean right = maxY[x] > y;
            boolean above = minX[y] < x;
            boolean below = maxX[y] > x;

            if (left && right && above && below) {
                covered++;
            }
        }

        return covered;
    }
}