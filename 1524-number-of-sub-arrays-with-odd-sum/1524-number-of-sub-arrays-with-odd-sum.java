class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oc = 0;int ec=1; 
        int total = 0;int prefixSum = 0;
        for(int num : arr){
            prefixSum += num;
            if(prefixSum % 2 != 0){ 
                total=(total + ec) % MOD;
                oc++;
            } 
            else{
                total =(total+oc) % MOD;
                ec++;
            }
        }
        return total;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna