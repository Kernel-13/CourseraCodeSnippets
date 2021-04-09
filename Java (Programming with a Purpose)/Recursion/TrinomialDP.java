public class TrinomialDP {

    public static long trinomial(int n, int k) {
        k = Math.abs(k);
        int[][] trinomials = new int[2 * n + 1][2 * n + 1];
        trinomials[0][0] = 1;

        for (int i = 1; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j == 0) {
                    trinomials[i][j] = trinomials[i - 1][j] + trinomials[i - 1][j + 1] * 2;
                }
                else {
                    trinomials[i][j] = trinomials[i - 1][j - 1] + trinomials[i - 1][j] + trinomials[
                            i - 1][j + 1];
                }
            }
        }

        return trinomials[n][k];

    }

    public static void main(String[] args) {
        StdOut.println(trinomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
