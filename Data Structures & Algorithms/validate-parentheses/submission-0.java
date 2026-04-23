class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
       
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else {
                if(st.isEmpty()) return false;
                char top = st.pop();
                if(!isMatch(top, ch)){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    private boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
