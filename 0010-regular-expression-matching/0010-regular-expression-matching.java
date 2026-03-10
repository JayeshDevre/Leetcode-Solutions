class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p, memo);
    }

    private boolean dfs(int i, int j, String s, String p, Boolean[][] memo) {
        if (memo[i][j] != null) return memo[i][j];

        // pattern finished: must also finish string
        if (j == p.length()) return memo[i][j] = (i == s.length());

        boolean firstMatch = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // if next char is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // 1) skip "x*"  OR 2) use one char if match and stay on same pattern j
            return memo[i][j] = (dfs(i, j + 2, s, p, memo) ||
                                (firstMatch && dfs(i + 1, j, s, p, memo)));
        }

        // normal match
        return memo[i][j] = (firstMatch && dfs(i + 1, j + 1, s, p, memo));
    }
}