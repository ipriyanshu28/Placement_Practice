class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int c1= image[sr][sc];
        if (c1 == color) return image;
        dfs(image, sr, sc, c1, color);
        return image;

    }
    private void dfs(int[][] image, int r, int c, int c1, int color) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;
        if (image[r][c] != c1) return;
        image[r][c] = color;
        dfs(image, r + 1, c, c1, color);
        dfs(image, r - 1, c, c1, color);
        dfs(image, r, c + 1, c1, color);
        dfs(image, r, c - 1, c1, color);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna