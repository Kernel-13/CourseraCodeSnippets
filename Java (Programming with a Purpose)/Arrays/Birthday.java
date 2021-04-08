public class Birthday {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] times = new int[n+2];

        for (int i = 0; i < trials; i++) {
            boolean[] birthdays = new boolean[n];

            for (int j = 0; j < n; j++) {
                int choice = (int) (Math.random() * n);

                if (birthdays[choice]) { times[j]++; break; }
                else { birthdays[choice] = true; }
            }
        }

        double prob = 0.0;
        int count = 0;
        while (prob < 0.5) {
            int sum = 0;
            for (int i = 0; i <= count; i++) { sum += times[i]; }
            prob = (double) sum / (double) trials;
            System.out.println(count+1 + "\t" + times[count] + "\t" + prob);
            count++;
        }
    }
}
