class Solution {
    public int diagonalSum(int[][] mat) {
       int primarySum = 0;
    int secondarySum = 0;
    int n = mat.length;

    for (int i = 0; i < n; i++) {
        primarySum += mat[i][i]; // Primary diagonal
        secondarySum += mat[i][n - i - 1]; // Secondary diagonal
    }

    // If matrix size is odd, subtract the middle element (counted twice)
    if (n % 2 == 1) {
        secondarySum -= mat[n / 2][n / 2];
    }

    return primarySum + secondarySum;
    }
}