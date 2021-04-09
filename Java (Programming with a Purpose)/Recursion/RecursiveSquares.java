public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        // drawSquare(x, y, length / 2);
        // StdOut.println(x + " " + y + " " + length);

        draw(n - 1, x - length / 2, y + length / 2, length / 2);
        draw(n - 1, x + length / 2, y + length / 2, length / 2);
        drawSquare(x, y, length / 2);
        draw(n - 1, x + length / 2, y - length / 2, length / 2);
        draw(n - 1, x - length / 2, y - length / 2, length / 2);
        // drawSquare(x, y, length);
        // StdOut.println("Drawing: X = " + x + " || y = " + y + " || N = " + n);
        // return;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
