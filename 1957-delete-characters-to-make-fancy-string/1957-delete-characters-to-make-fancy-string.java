class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        result.append(s.charAt(0)); // Always include first character

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1; // Reset count if different char
            }

            if (count < 3) {
                result.append(s.charAt(i)); // Only append if less than 3 consecutive
            }
        }

        return result.toString();
    }
}