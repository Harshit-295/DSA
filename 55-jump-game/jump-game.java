class Solution {
    public boolean canJump(int[] nums) {
        int maxjump = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i>maxjump)return false;
            else{
                maxjump = Math.max(maxjump,i+nums[i]);
            }
        }
        return true;
    }
}