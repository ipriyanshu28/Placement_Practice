class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> result=new ArrayList<>();
        boolean[] prime=new boolean[n+1];
        for(int i=2;i<=n;i++){
            prime[i]=true;
        }
        for(int p=2;p*p<=n;p++){
            if(prime[p]){
                for(int i= p*p;i<=n;i+=p){
                    prime[i]=false;
                }
            }
        }
        int sum=0;
        for(int i=2;i<=n;i++){
            if(prime[i]){
                if(sum+i<=s){
                    result.add(i);
                    sum+=i;
                }
                else{
                    break;
                }
            }
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna