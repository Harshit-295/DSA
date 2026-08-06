class Solution {
    public int pro(int n){
        int pro = 1;
        while(n>0){
            pro*=n%10;
            n=n/10;
        }
        return pro;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=n+10;i++){
            if(pro(i)%t==0)return i;
        }
        return -1;
    }
}