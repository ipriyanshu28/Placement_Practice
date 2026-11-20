class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> dp=new HashMap<>();
        int ans=0;
        for(int x : nums){
            int lenPlusOne=dp.getOrDefault(x,0)+1;
            int lenSame=dp.getOrDefault(x-1,0)+1;
            dp.put(x+1,Math.max(dp.getOrDefault(x+1,0),lenPlusOne));
            dp.put(x,Math.max(dp.getOrDefault(x,0),lenSame));
            ans=Math.max(ans,Math.max(lenPlusOne,lenSame));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna