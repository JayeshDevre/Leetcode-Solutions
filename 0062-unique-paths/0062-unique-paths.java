class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];

        // I initialize the first row and first column; there's only one way to reach those cells
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // I fill in the DP table using the relation: dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // I return the final value at the bottom-right corner
        return dp[m - 1][n - 1];
    }
}