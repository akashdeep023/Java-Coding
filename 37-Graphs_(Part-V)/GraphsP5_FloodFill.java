public class GraphsP5_FloodFill {
    public static void helper(int images[][], int sr, int sc, int color, boolean[][] visited, int orgColor) {
        if (sr < 0 || sc < 0 || sr >= images.length || sc >= images[0].length || visited[sr][sc]
                || images[sr][sc] != orgColor) {
            return;
        }
        visited[sr][sc] = true; // visited
        // left
        helper(images, sr, sc - 1, color, visited, images[sr][sc]);
        // right
        helper(images, sr, sc + 1, color, visited, images[sr][sc]);
        // up
        helper(images, sr - 1, sc, color, visited, images[sr][sc]);
        // down
        helper(images, sr + 1, sc, color, visited, images[sr][sc]);
        images[sr][sc] = color; // update color

    }

    // Flood fill algorithm --------------------------------
    public static int[][] floodFill(int images[][], int sr, int sc, int color) {
        boolean[][] visited = new boolean[images.length][images[0].length];
        helper(images, sr, sc, color, visited, images[sr][sc]);
        return images;
    }

    // Print Image ---
    public static void printImage(int images[][]) {
        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j < images[0].length; j++) {
                System.out.print(images[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Flood fill algorithm --------------------------------
        // Given a m X n integer grid image where image[i][j] represents the pixel value of the image.
        // You are also given three integers sr, sc, and color. You should perform a flood fill on the 
        // image starting from the pixel image[sr][sc].
        // To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the
        // starting pixel of the same color as the starting pixel, plux any pixels connected 4-directionally to those 
        // pixels (also with the same color), and so on. Replace the color of all the aforementioned pixels with color.
        int images[][] = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 },
        };
        int sr = 1; // starting row
        int sc = 1; // starting coloum
        int color = 2; // fill color
        floodFill(images, sr, sc, color);
        printImage(images);
    }
}
