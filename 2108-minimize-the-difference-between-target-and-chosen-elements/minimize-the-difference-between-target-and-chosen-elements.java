class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        for (int i = 0; i < mat.length; i++) {
            Set<Integer> nextSums = new HashSet<>();

            for (int prevSum : sums) {
                for (int j = 0; j < mat[0].length; j++) {
                    nextSums.add(prevSum + mat[i][j]);
                }
            }
            sums = nextSums;
        }
        int ans = Integer.MAX_VALUE;
        for (int sum : sums) {
            ans = Math.min(ans, Math.abs(sum - target));
        }
        return ans;
    }
}
