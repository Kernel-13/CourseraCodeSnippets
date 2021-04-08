public class RandomWalker {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int manDistance = 0;
        int x = 0;
        int y = 0;
        int count = 0;
        System.out.println("(" + x + "," + y +")");

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
            System.out.println("(" + x + "," + y +")");
            count++;
            manDistance = Math.abs(x) + Math.abs(y);
        }

        System.out.println("steps = " + count);
    }
}
