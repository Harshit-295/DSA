class Solution {

    int helper(int[][] mat, int target, int i, int sum, Integer[][] dp) {
        if (i == mat.length) {
            return Math.abs(sum - target);
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        int minDiff = Integer.MAX_VALUE;
        for (int j = 0; j < mat[0].length; j++) {
            int diff = helper(mat, target, i + 1, sum + mat[i][j], dp);
            minDiff = Math.min(minDiff, diff);
        }

        dp[i][sum] = minDiff;
        return minDiff;
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        Integer[][] dp = new Integer[n][5001];
        return helper(mat, target, 0, 0, dp);
    }
}
