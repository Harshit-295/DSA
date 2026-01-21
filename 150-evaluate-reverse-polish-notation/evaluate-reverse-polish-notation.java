class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int n = st.pop();
                if (!st.isEmpty()) {
                    int res = 0;
                    if (t.equals("+")) {
                        res = st.pop() + n;
                    }
                    if (t.equals("-")) {
                        res = st.pop() - n;
                    }
                    if (t.equals("/")) {
                        res = st.pop() / n;
                    }
                    if (t.equals("*")) {
                        res = st.pop() * n;
                    }
                    st.push(res);
                }
            } 
            else {
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}
