class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int max = nums[n-1];
        int min = nums[0];
        System.out.println(max);
        int[] arr = new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        for(int i=min;i<=max;i++){
            if(arr[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}