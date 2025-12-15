class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();

        // Fill row and column maps
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            rowMap.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            colMap.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int covered = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            TreeSet<Integer> row = rowMap.get(x);
            TreeSet<Integer> col = colMap.get(y);

            // Check left: y2 < y
            Integer left = row.lower(y);

            // Check right: y2 > y
            Integer right = row.higher(y);

            // Check above: x2 < x
            Integer above = col.lower(x);

            // Check below: x2 > x
            Integer below = col.higher(x);

            if (left != null && right != null && above != null && below != null) {
                covered++;
            }
        }

        return covered;
    }
}