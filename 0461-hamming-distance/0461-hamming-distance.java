class Solution {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        int n = x ^ y;
        while(n != 0) {
            n = n & (n-1);
            cnt++;
        }

        return cnt;
    }
} 