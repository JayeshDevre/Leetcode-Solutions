class Solution {
    public int calculate(String s) {
        int total = 0, last = 0, number = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) number = number * 10 + (ch - '0');

            if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == s.length() - 1) {
                if (op == '+') { total += last; last = number; }
                else if (op == '-') { total += last; last = -number; }
                else if (op == '*') { last = last * number; }
                else if (op == '/') { last = last / number; }

                op = ch;
                number = 0;
            }
        }
        return total + last;
    }
}
