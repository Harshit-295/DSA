class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int n = nums.length;
        int[] arr = new int[n];
        int l = 0;
        for(int i=2;i<n;i++){
            int k = arr1.size()-1;
            int m = arr2.size()-1;
            if(arr1.get(k)>=arr2.get(m)){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }
        for(int i=0;i<arr1.size();i++){
            arr[l]=arr1.get(i);
            l++;
        }
        for(int j=0;j<arr2.size();j++){
            arr[l]=arr2.get(j);
            l++;
        }
        return arr;
    }
}