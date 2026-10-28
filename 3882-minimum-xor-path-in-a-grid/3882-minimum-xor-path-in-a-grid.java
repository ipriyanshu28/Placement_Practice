class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][][] dp=new boolean[n][m][1024];
        dp[0][0][grid[0][0]]=true;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    continue;
                }
                for(int x=0; x<1024; x++){
                    if(i>0 && dp[i-1][j][x]){
                        dp[i][j][x^grid[i][j]]=true;
                    }
                    if(j>0 && dp[i][j-1][x]){
                        dp[i][j][x^grid[i][j]]=true;
                    }
                }
            }
        }
        for(int x=0;x<1024;x++){
            if(dp[n-1][m-1][x]){
                return x;
            }
        }
        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna