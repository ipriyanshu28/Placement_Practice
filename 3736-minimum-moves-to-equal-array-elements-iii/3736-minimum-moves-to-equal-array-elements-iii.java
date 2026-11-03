class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int maxval=nums[0];
        int total=0;
        for(int num : nums){
            if(num > maxval){
                maxval=num;
            }
            total += num;
        } 
        return maxval*n-total;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna