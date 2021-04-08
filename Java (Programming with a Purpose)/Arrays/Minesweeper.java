public class Minesweeper {

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);


        String[][] grid = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = "0";
            }
        }

        // Fills with mines
        int mineCount = 0;
        while (mineCount < k) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);
            if (grid[x][y].equals("0")) {
                grid[x][y] = "*";
                mineCount++;
            }
        }

        // Checks for mines nearby
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int nearbyMines = 0;
                if (!grid[i][j].equals("*")) {
                    if (i > 0 && j > 0 && grid[i-1][j-1].equals("*")) { nearbyMines++; }
                    if (j > 0 && grid[i][j-1].equals("*")) { nearbyMines++; }
                    if (j > 0 && i < m-1 && grid[i+1][j-1].equals("*")) { nearbyMines++; }

                    if (i > 0 && grid[i-1][j].equals("*")) { nearbyMines++; }
                    if (i < m-1 && grid[i+1][j].equals("*")) { nearbyMines++; }

                    if (i > 0 && j < n-1 && grid[i-1][j+1].equals("*")) { nearbyMines++; }
                    if (j < n-1 && grid[i][j+1].equals("*")) { nearbyMines++; }
                    if (i < m-1 && j < n-1 && grid[i+1][j+1].equals("*")) { nearbyMines++; }

                    grid[i][j] = String.valueOf(nearbyMines);
                }

            }
        }

        // Prints the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
