public class Checkerboard {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        
        for (int i = 0; i < n; i++) {

            if (i % 2 == 1) {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            }
            else {
                StdDraw.setPenColor(StdDraw.BLUE);
            }

            for (int j = 0; j < n; j++) {
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                if (!StdDraw.getPenColor().equals(StdDraw.BLUE)) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
            }

        }
    }

}
