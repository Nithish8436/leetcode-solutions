class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> l = new ArrayList<>();
        int temp = n;
        while (temp != 0) {
            l.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(l); // now digits are in normal order (MSD → LSD)

        int ind = -1;
        // Step 1: Find pivot (from right)
        for (int i = l.size() - 2; i >= 0; i--) {
            if (l.get(i) < l.get(i + 1)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) return -1;

        // Step 2: Find rightmost digit greater than pivot
        int j = l.size() - 1;
        while (l.get(j) <= l.get(ind)) {
            j--;
        }

        // Step 3: Swap
        Collections.swap(l, ind, j);

        // Step 4: Reverse suffix
        Collections.reverse(l.subList(ind + 1, l.size()));

        // Step 5: Build number
        long ans = 0;
        for (int d : l) {
            ans = ans * 10 + d;
        }

        return (ans > Integer.MAX_VALUE) ? -1 : (int) ans;
    }
}