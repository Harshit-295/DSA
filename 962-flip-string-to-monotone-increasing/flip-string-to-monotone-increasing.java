class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int lhs[] = new int[n + 1];
        int rhs[] = new int[n + 1];
        for(int i = 0; i < n; i++) {
            lhs[i + 1] = lhs[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        for(int i = n - 1; i >= 0; i--) {
            rhs[i] = rhs[i + 1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++) {
            min = Math.min(min, lhs[i] + rhs[i]);
        }
        return min;
    }
}