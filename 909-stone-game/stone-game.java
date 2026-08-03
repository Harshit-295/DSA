class Solution {
    Integer[][] dp;
    int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int takeLeft = nums[start] - helper(nums, start + 1, end);
        int takeRight = nums[end] - helper(nums, start, end - 1);
        dp[start][end] = Math.max(takeLeft, takeRight);
        return dp[start][end];
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];

        return helper(piles, 0, n - 1) >= 0;
    }
}