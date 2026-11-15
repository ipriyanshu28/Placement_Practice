class Solution {
    public long maxDifference(int[] nums) {
        int n=nums.length;
        long n1=0,n2=0;
        for(int i=n-1;i>=0;i--){
            long s1=nums[i];
            long val1=(s1% 3==0)?(s1-n1):(s1+n1);
            long curr=val1;
            if(i+1<n){
                long s2=(long)nums[i]+nums[i+1];
                long val2=(s2%3==0)?(s2-n2):(s2+n2);
                curr=Math.max(curr,val2);
            }
            n2=n1;
            n1=curr;
        }
        return n1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna