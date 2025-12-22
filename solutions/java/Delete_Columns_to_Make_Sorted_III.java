class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        
        int[] dp = new int[n];
        int maxKeep = 1;
        
        // Each column alone is valid
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (canExtend(strs, i, j)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            maxKeep = Math.max(maxKeep, dp[j]);
        }
        
        return n - maxKeep;
    }
    
    // Check if column i can come before column j
    private boolean canExtend(String[] strs, int i, int j) {
        for (String s : strs) {
            if (s.charAt(i) > s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
