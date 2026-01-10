class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] dp = new int[n + 1];

        // Base case: s1 is empty
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            int prevDiagonal = dp[0];   // dp[i-1][0]
            dp[0] += s1.charAt(i - 1); // base case: s2 empty

            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // store old dp[i-1][j]

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prevDiagonal;
                } else {
                    dp[j] = Math.min(
                        dp[j] + s1.charAt(i - 1),      // delete from s1
                        dp[j - 1] + s2.charAt(j - 1)   // delete from s2
                    );
                }

                prevDiagonal = temp;
            }
        }

        return dp[n];
    }
}
