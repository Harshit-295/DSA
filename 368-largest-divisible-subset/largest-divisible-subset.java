class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int pick = 0;
                if (prev == -1 || nums[index] % nums[prev] == 0) {
                    pick = 1 + dp[index + 1][index + 1];
                }
                int notPick = dp[index + 1][prev + 1];
                dp[index][prev + 1] = Math.max(pick, notPick);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        int prev = -1;
        while (index < n) {
            int notPick = dp[index + 1][prev + 1];
            int pick = 0;
            if (prev == -1 || nums[index] % nums[prev] == 0) {
                pick = 1 + dp[index + 1][index + 1];
            }
            if (pick > notPick) {
                ans.add(nums[index]);
                prev = index;
            }
            index++;
        }
        return ans;
    }
}