class Solution {
    public int minimumDeletions(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        int s = 0;
        int e = 0;
        int mind = 0;
        int maxd = 0;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        for (int i = 0; i < n; i++) {

            if (nums[i] == max) {
                maxIndex = i;
            }

            if (nums[i] == min) {
                minIndex = i;
            }
        }
        mind = minIndex + 1;
        maxd = maxIndex + 1;
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);
        int ans1 = right + 1;
        int ans2 = n - left;
        int ans3 = left + 1 + n - right;

        return Math.min(ans1, Math.min(ans2, ans3));
    }
}