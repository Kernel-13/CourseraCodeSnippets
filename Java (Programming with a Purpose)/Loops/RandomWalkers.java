public class RandomWalkers {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int sumCounts = 0;
        for (int i = 0; i < trials; i++) {
            int manDistance = 0;
            int x = 0;
            int y = 0;
            int count = 0;

            while (manDistance != r) {
                double prob = Math.random();
                if (prob < 0.25) {
                    y++;
                } else if (prob >= 0.25 && prob < 0.5) {
                    x++;
                } else if (prob >= 0.5 && prob < 0.75) {
                    y--;
                } else if (prob >= 0.75) {
                    x--;
                }

                count++;
                manDistance = Math.abs(x) + Math.abs(y);
            }
            sumCounts += count;
        }
        System.out.println("average number of steps = " +  ((double) sumCounts / (double) trials));
    }
}
