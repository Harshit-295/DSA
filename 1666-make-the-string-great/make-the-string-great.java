class Solution {
    public String makeGood(String s) {
        StringBuilder sb= new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(Character c:s.toCharArray()){
            if(!st.isEmpty() && (int)Math.abs(st.peek()-c)==32){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}