class Solution {
    public boolean threeFibonacciSum(int n) {
        if(n%2!=0){
            return false;
        } 
        int target=n/2;
        if(target==0||target==1){
            return true;
        }
        int a=0,b=1;
        while(b<target){
            int next=a+b;
            a=b;
            b=next;
        }
        return b==target;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna