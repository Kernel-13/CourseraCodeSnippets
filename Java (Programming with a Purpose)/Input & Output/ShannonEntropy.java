public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] integers = new int[m + 1];

        // Fills our dict
        int count = 0;
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            integers[i]++;
            count++;
        }

        // Calculates Shannon entropy
        double shannonEntropy = 0.0;
        for (int i = 1; i < integers.length; i++) {
            double pI = (double) integers[i] / (double) count;
            if (pI != 0.0) {
                shannonEntropy += (Math.log(pI) / Math.log(2)) * pI * -1;
            }
        }

        StdOut.printf("%.4f\n", shannonEntropy);
    }
}
