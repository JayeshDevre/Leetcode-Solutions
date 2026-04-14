class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        int l = 0, r = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int startI = -1;

        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
            r++;

            while (count == t.length()) {
                if (r - l < minLength) {
                    minLength = r - l;
                    startI = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startI, startI + minLength);
    }
}