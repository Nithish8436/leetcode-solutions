class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long NEG = Long.MIN_VALUE / 2;

        // dp[t][state]
        // state 0 = idle
        // state 1 = holding long
        // state 2 = holding short
        long[][] dp = new long[k + 1][3];

        // initialization
        for (int t = 0; t <= k; t++) {
            dp[t][0] = 0;
            dp[t][1] = NEG;
            dp[t][2] = NEG;
        }

        for (int price : prices) {
            long[][] newDp = new long[k + 1][3];

            // copy previous values
            for (int t = 0; t <= k; t++) {
                newDp[t][0] = dp[t][0];
                newDp[t][1] = dp[t][1];
                newDp[t][2] = dp[t][2];
            }

            for (int t = 0; t <= k; t++) {

                // start normal transaction (buy)
                newDp[t][1] = Math.max(newDp[t][1], dp[t][0] - price);

                // start short transaction (sell)
                newDp[t][2] = Math.max(newDp[t][2], dp[t][0] + price);

                if (t > 0) {
                    // finish normal transaction (sell)
                    newDp[t][0] = Math.max(newDp[t][0], dp[t - 1][1] + price);

                    // finish short transaction (buy back)
                    newDp[t][0] = Math.max(newDp[t][0], dp[t - 1][2] - price);
                }
            }

            dp = newDp;
        }

        long ans = 0;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[t][0]);
        }
        return ans;
    }
}
