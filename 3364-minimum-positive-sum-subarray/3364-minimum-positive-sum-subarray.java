class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int minsum=Integer.MAX_VALUE;
        for(int i=0;i<=n-1;i++){
            int currsum=0;
            int maxend=Math.min(n-1,i+r-1);
            for(int j=i;j<=maxend;j++){
                currsum += nums.get(j);
                int length=j-i+1;
                if(length>=l && currsum>0){
                    minsum=Math.min(minsum,currsum);
                }
            }
        }
        return (minsum == Integer.MAX_VALUE)?-1:minsum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna