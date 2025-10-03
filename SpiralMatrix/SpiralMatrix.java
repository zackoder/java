public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];
        int t = 0;
        int l = 0;
        int b = n - 1;
        int r = n - 1;
        int current = 1;
        while (current <= n * n) {
            for (int i = l; i <= r; i++) {
                spiral[t][i] = current++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                spiral[i][r] = current++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                spiral[b][i] = current++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                spiral[i][l] = current++;
            }
            l++;
        }
        return spiral;
    }
}