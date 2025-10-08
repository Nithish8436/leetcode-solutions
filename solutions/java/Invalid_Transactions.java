import java.util.*;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        boolean[] invalid = new boolean[n];

        // Step 1: Split all transactions into parts for easy comparison
        String[][] data = new String[n][4];
        for (int i = 0; i < n; i++) {
            data[i] = transactions[i].split(",");
        }

        // Step 2: Check each transaction for invalid conditions
        for (int i = 0; i < n; i++) {
            String name1 = data[i][0];
            int time1 = Integer.parseInt(data[i][1]);
            int amount1 = Integer.parseInt(data[i][2]);
            String city1 = data[i][3];

            // Rule 1: Amount greater than 1000
            if (amount1 > 1000) {
                invalid[i] = true;
            }

            // Rule 2: Compare with every other transaction
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                String name2 = data[j][0];
                int time2 = Integer.parseInt(data[j][1]);
                String city2 = data[j][3];

                // Same name, within 60 minutes, different city
                if (name1.equals(name2) && Math.abs(time1 - time2) <= 60 && !city1.equals(city2)) {
                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        // Step 3: Collect invalid transactions
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i]) {
                result.add(transactions[i]);
            }
        }

        return result;
    }
}
