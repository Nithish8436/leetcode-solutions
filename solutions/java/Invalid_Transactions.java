import java.util.*;

class Solution {

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;
        String original;
        boolean invalid;

        Transaction(String name, int time, int amount, String city, String original) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
            this.original = original;
            this.invalid = false;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<Transaction> list = new ArrayList<>();

        // Step 1: Parse all transactions
        for (String t : transactions) {
            String[] parts = t.split(",");
            list.add(new Transaction(parts[0], Integer.parseInt(parts[1]), 
                                     Integer.parseInt(parts[2]), parts[3], t));
        }

        // Step 2: Group by name
        Map<String, List<Transaction>> map = new HashMap<>();
        for (Transaction tr : list) {
            map.computeIfAbsent(tr.name, k -> new ArrayList<>()).add(tr);
        }

        // Step 3: Check invalid conditions within each name
        for (List<Transaction> group : map.values()) {
            // Sort transactions by time
            group.sort(Comparator.comparingInt(t -> t.time));
            int n = group.size();

            for (int i = 0; i < n; i++) {
                Transaction t1 = group.get(i);

                // Rule 1: amount > 1000
                if (t1.amount > 1000) {
                    t1.invalid = true;
                }

                // Rule 2: Compare only forward transactions within 60 mins
                for (int j = i + 1; j < n; j++) {
                    Transaction t2 = group.get(j);
                    if (t2.time - t1.time > 60) break; // stop if time difference > 60

                    if (!t1.city.equals(t2.city)) {
                        t1.invalid = true;
                        t2.invalid = true;
                    }
                }
            }
        }

        // Step 4: Collect invalid transactions
        List<String> result = new ArrayList<>();
        for (Transaction tr : list) {
            if (tr.invalid) result.add(tr.original);
        }

        return result;
    }
}
