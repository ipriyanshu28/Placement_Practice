class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int[] freeCount=new int[n];
        for(int i = 0; i < n; i++){
            int fi = items[i][0];
            int c = 0;
            for(int j = 0; j < n; j++){
                if(i!=j && items[j][0] % fi==0){
                    c++;
                }
            }
            freeCount[i]=c;
        }
        int[] dp=new int[budget+1];
        for(int i=0;i<n;i++){
            int price=items[i][1];
            if(price>budget){
                continue;
            }
            int firstGain=1+freeCount[i];
            for(int b = budget; b >= price; b--){
                dp[b] = Math.max(dp[b], dp[b - price] + firstGain);
            }
            for(int b=price;b<=budget;b++){
                dp[b]=Math.max(dp[b],dp[b-price]+1);
            }
        }
        int ans = 0;
        for (int val : dp) {
            ans = Math.max(ans, val);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna