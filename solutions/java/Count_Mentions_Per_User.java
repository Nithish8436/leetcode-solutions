import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        // Sort events by timestamp, OFFLINE before MESSAGE if same time
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        int[] result = new int[numberOfUsers];

        long[] offlineUntil = new long[numberOfUsers];
        Arrays.fill(offlineUntil, -1);

        Set<Integer> online = new HashSet<>();
        for (int i = 0; i < numberOfUsers; i++) {
            online.add(i);
        }

        for (List<String> event : events) {
            String type = event.get(0);
            long time = Long.parseLong(event.get(1));

            // Bring users back online if their offline time expired
            for (int i = 0; i < numberOfUsers; i++) {
                if (offlineUntil[i] != -1 && offlineUntil[i] <= time) {
                    online.add(i);
                    offlineUntil[i] = -1;
                }
            }

            if (type.equals("OFFLINE")) {
                int user = Integer.parseInt(event.get(2));
                online.remove(user);
                offlineUntil[user] = time + 60;
            } 
            else { // MESSAGE
                String msg = event.get(2);

                if (msg.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        result[i]++;
                    }
                } 
                else if (msg.equals("HERE")) {
                    for (int u : online) {
                        result[u]++;
                    }
                } 
                else {
                    for (String s : msg.split(" ")) {
                        int id = Integer.parseInt(s.substring(2));
                        result[id]++;
                    }
                }
            }
        }
        return result;
    }
}