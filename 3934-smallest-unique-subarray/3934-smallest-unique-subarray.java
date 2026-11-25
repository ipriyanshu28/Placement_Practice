class Solution {
    private static final long BASE1 = 100003L;
    private static final long MOD1 = 1_000_000_007L;
    private static final long BASE2 = 100019L;
    private static final long MOD2 = 1_000_000_009L;
    private long[] pow1;
    private long[] pow2;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        pow1 = new long[n + 1];
        pow2 = new long[n + 1];
        pow1[0] = 1L;
        pow2[0] = 1L;
        for(int i = 1; i <= n; i++){
            pow1[i] = (pow1[i - 1] * BASE1) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE2) % MOD2;
        }
        int low = 1;int high = n;int ans = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(hasUniqueSubarrayOfLength(nums, mid)){
                ans = mid;
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean hasUniqueSubarrayOfLength(int[] nums, int len){
        int n = nums.length;
        long h1 = 0L;
        long h2 = 0L;
        for(int i = 0; i < len; i++){
            long val = nums[i] + 1L;
            h1 = (h1 * BASE1 + val) % MOD1;
            h2 = (h2 * BASE2 + val) % MOD2;
        }
        Map<Long, Integer> freq = new HashMap<>();
        long combined = pack(h1, h2);
        freq.put(combined, 1);
        long factor1 = pow1[len - 1];
        long factor2 = pow2[len - 1];
        for (int i = len; i < n; i++) {
            long outVal = nums[i - len] + 1L;
            long inVal = nums[i] + 1L;
            h1 = (h1 - (outVal * factor1) % MOD1 + MOD1) % MOD1;
            h1 = (h1 * BASE1 + inVal) % MOD1;
            h2 = (h2 - (outVal * factor2) % MOD2 + MOD2) % MOD2;
            h2 = (h2 * BASE2 + inVal) % MOD2;
            combined = pack(h1, h2);
            freq.put(combined, freq.getOrDefault(combined, 0) + 1);
        }
        for(int count : freq.values()){
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
    private long pack(long h1, long h2){
        return (h1 << 32) | (h2 & 0xffffffffL);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna