class Solution {
    public int minOperations(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && i+2>=nums.length){
                return -1;
            }
            else if(nums[i]==0 && i+2<nums.length){
                nums[i]=1;
                nums[i+1]=nums[i+1]==0?1:0;
                nums[i+2]=nums[i+2]==0?1:0;
                c++;
            }
        }
        return c;
    }
}