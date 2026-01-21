class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean ans[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            ans[i] = true;
        }
        ans[0] = false;
        ans[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (ans[i]) {
                for (int j = i * i; j < n; j += i) {
                    ans[j] = false;
                }
            }
        }
        int count = 0;
        for (int p = 2; p < n; p++) {
            if (ans[p]) count++;
        }
        return count;
    }
}
