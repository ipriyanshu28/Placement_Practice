class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        long maxPossibleLcm=2520L; 
        for (int i=0;i<n;i++){
            long prod = 1L;
            long curGcd = 0L;
            long curLcm = 1L;
            for (int j=i;j<n;j++){
                long val=nums[j];
                if (prod > Long.MAX_VALUE /val){
                    break;
                }
                prod *= val;
                curGcd = (curGcd == 0L) ? val : gcd(curGcd, val);
                curLcm = lcm(curLcm, val);
                if(prod == curLcm * curGcd){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                if (prod>maxPossibleLcm * curGcd * curLcm){
                    break;
                }
            }
        }
        return maxLen;
    }
    private long gcd(long a, long b) {
        while (b != 0L) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
    

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna