public class ThueMorse {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        boolean[] thue = new boolean[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && Math.pow(2,i) < n; j++) {
                thue[(int) Math.pow(2,i) + j] = !thue[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thue[i] == thue[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
