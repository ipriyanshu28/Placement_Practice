class Solution {
    public int countConsistent(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int currand=nums[i];
            int currmin=nums[i];
            for(int j=i;j<n;j++){
                currand &= nums[j];
                currmin = Math.min(currmin,nums[j]);
                if(currand==currmin){
                    count++;
                }
            }
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna