class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE;
        int secmax = Integer.MIN_VALUE;
        while(n>0){
            int k = n%10;
            if(k>max){
                secmax = max;
                max = k;
            }
            else if((k==max || k<max ) && k>secmax){
                secmax = k;
            }
            n=n/10;
        }
        return max*secmax;
    }
}