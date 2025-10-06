class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If closing bracket but nothing to match
                if (stack.empty()) return false;
                
                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                else if (ch == '}' && top != '{') return false;
                else if (ch == ']' && top != '[') return false;
            }
        }
        
        return stack.empty(); // all brackets matched
    }
}
