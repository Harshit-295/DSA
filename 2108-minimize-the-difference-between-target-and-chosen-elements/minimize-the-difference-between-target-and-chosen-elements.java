class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = 70 * 70;
        int[][] dp = new int[n + 1][maxSum + 1];

        for (int sum = 0; sum <= maxSum; sum++) {
            dp[n][sum] = Math.abs(sum - target);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int sum = 0; sum <= maxSum; sum++) {
                int minDiff = Integer.MAX_VALUE;

                for (int j = 0; j < m; j++) {
                    if (sum + mat[i][j] <= maxSum) {
                        minDiff = Math.min(
                            minDiff,
                            dp[i + 1][sum + mat[i][j]]
                        );
                    }
                }

                dp[i][sum] = minDiff;
            }
        }
        return dp[0][0];
    }
}

