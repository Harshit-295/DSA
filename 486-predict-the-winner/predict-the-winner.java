class Solution {
    boolean helper(int[] nums, boolean player1Turn,int sum1, int sum2,int start, int end) {
        if (start > end) {
            return sum1 >= sum2;
        }

        if (player1Turn) {
            boolean takeLeft = helper(nums, false,sum1 + nums[start], sum2,start + 1, end);
            boolean takeRight =helper(nums, false,sum1 + nums[end], sum2,start, end - 1);
            return takeLeft || takeRight;
        } else {
            boolean takeLeft = helper(nums, true,sum1, sum2 + nums[start],start + 1, end);
            boolean takeRight = helper(nums, true,sum1, sum2 + nums[end],start, end - 1);

            return takeLeft && takeRight;
        }
    }

    public boolean predictTheWinner(int[] nums) {
        return helper(nums, true, 0, 0, 0, nums.length - 1);
    }
}