class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int deleteCount = 0;

        // Traverse each column
        for (int c = 0; c < cols; c++) {
            // Check if column is sorted
            for (int r = 1; r < rows; r++) {
                if (strs[r].charAt(c) < strs[r - 1].charAt(c)) {
                    deleteCount++;   // column not sorted
                    break;           // move to next column
                }
            }
        }
        return deleteCount;
    }
}
