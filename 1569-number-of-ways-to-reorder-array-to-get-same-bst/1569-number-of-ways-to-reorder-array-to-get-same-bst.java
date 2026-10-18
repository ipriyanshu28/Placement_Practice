class Solution {
    static final int MOD = 1_000_000_007;
    long[][] comb; 
    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n + 1][n + 1];
        buildComb(n);
        return (int)((dfs(nums) - 1 + MOD) % MOD);
    }
    private long dfs(int[] nums) {
        if (nums.length <= 2) return 1;
        int root = nums[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) left.add(nums[i]);
            else right.add(nums[i]);
        }
        long leftWays = dfs(listToArray(left));
        long rightWays = dfs(listToArray(right));
        int l = left.size();
        int r = right.size();
        return (((comb[l + r][l] * leftWays) % MOD) * rightWays) % MOD;
    }
    private void buildComb(int n) {
        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
    }
    private int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna