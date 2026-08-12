class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int maxlen = 0;
        int maxfreq = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right])>k){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}