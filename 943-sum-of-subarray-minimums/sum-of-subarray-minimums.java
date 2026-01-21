import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;
        int[] psee = new int[n];
        int[] nseee = new int[n];  
        Arrays.fill(psee, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        Arrays.fill(nseee, n);
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nseee[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nseee[i] - i;
            ans = (ans + arr[i] * left * right) % MOD;
        }

        return (int) ans;
    }
}
