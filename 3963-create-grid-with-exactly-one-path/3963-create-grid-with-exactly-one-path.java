class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        for(int i=0;i<m;i++){
            java.util.Arrays.fill(grid[i],'#');
        }
        for(int j=0;j<n;j++){
            grid[0][j]='.';
        }
        for(int i=0;i<m;i++){
            grid[i][n-1]='.';
        }
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
            ans[i]=new String(grid[i]);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna