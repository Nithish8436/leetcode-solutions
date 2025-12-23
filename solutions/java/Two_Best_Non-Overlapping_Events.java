import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort by start time
        
        int n = events.length;
        int[] maxValueFrom = new int[n + 1];
        
        // fill maxValueFrom from bottom (suffix maximum)
        for (int i = n - 1; i >= 0; i--) {
            maxValueFrom[i] = Math.max(maxValueFrom[i + 1], events[i][2]);
        }

        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int end = events[i][1];
            int value = events[i][2];

            // binary search for first event starting after 'end'
            int left = i + 1, right = n - 1, next = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > end) {
                    next = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int bestNextValue = (next < n) ? maxValueFrom[next] : 0;

            maxSum = Math.max(maxSum, value + bestNextValue);
        }

        return maxSum;
    }
}
