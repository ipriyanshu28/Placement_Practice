class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;int high=0;
        for(int p : piles){
            if(p>high){
                high=p;
            }
        }
        while(low<high){
            int mid = low+(high-low)/2;
            if(canFinish(piles,h,mid)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean canFinish(int[] piles,int h,int speed){
        long hours=0;
        for(int p : piles){
            hours += ((long)p+speed-1)/speed;
            if (hours > h){
                return false;
            }
        }
        return hours <= h;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna