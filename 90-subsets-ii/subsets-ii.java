class Solution {
    public static void helper(int index,int[] nums, List<List<Integer>> l2,List<Integer> l1){
        l2.add(new ArrayList<>(l1));
        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            l1.add(nums[i]);
            helper(i+1,nums,l2,l1);
            l1.remove(l1.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> l2= new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> l1= new ArrayList<>();
        helper(0,nums,l2,l1);
        return l2;
    }
}