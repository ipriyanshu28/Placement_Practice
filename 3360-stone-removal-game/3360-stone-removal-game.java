class Solution {
    public boolean canAliceWin(int n) {
        int remove=10;
        boolean aliceTurn = true;
        while(n>=remove){
            n-=remove;
            remove--;
            aliceTurn =! aliceTurn;
        }
        return !aliceTurn;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna