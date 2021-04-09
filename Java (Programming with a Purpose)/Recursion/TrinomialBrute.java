public class TrinomialBrute {

    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }

    public static void main(String[] args) {
        StdOut.println(trinomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
