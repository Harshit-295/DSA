class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] maxa = new int[n];
        int[] mina = new int[n];
        maxa[0] = nums[0];

        for (int i = 1; i < n; i++) {
            maxa[i] = Math.max(maxa[i - 1], nums[i]);
        }
        mina[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mina[i] = Math.min(mina[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            int score = maxa[i] - mina[i];
            if (score <= k) {
                return i;
            }
        }

        return -1;
    }
}