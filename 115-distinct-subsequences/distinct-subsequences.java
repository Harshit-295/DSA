class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(s, t, 0, 0,dp);
    }

    private int helper(String s, String t, int i, int j,int[][] dp) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        int ways = 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            ways += helper(s, t, i + 1, j + 1,dp);
        }
        ways += helper(s, t, i + 1, j,dp);

        dp[i][j]=ways;
        return ways;
    }
}