class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n=nums.length;
        int[] freq=new int[100001];
        for(int x : nums) freq[x]++;
        for(int x : target) freq[x]--;
        for(int f : freq){
            if(f!=0)return 0;
        }
        int p=n;
        for(int i=0;i<n;i++){
            if(nums[i]!=target[i]){
                p=i;
                break;
            }
        }
        int q=-1;
        for(int i=0;i<n-1;i++){
            if(target[i]<target[i+1]){
                q=i;
            }
        }
        return Math.max(0,Math.min(p,n-1)-q);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna