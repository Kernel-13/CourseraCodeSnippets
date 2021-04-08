public class DiscreteDistribution {

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] n = new int[args.length-1];
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(args[i+1]);
        }

        int[] s = new int[n.length+1];
        s[0] = 0;
        for (int i = 1; i <= n.length; i++) {
            for (int j = 0; j < i; j++) {
                s[i] += n[j];
            }
        }

        for (int x = 0; x < m; x++) {
            int r = (int) (Math.random() * (s[n.length] - 1));
            int index = 0;
            for (int i = 0; i < s.length-1; i++) {
                if (s[i] >= r && r < s[i+1]) {
                    index = i;
                    break;
                }
            }
            System.out.print(index+1 + " ");
        }
    }
}
