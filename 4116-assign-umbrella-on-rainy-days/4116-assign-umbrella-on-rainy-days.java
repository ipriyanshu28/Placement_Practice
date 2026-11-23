class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n=rain.length;
        String[] ans=new String[n];
        int alicecount=0,bobcount=0;
        for(int i=0;i<n;i++){
            if(rain[i]==0){
                ans[i]="None";
                continue;
            }
            boolean bobneeds=true;
            boolean aliceneeds=(i+1<n)&&(rain[i+1]==1);
            if(aliceneeds && bobneeds){
                if(alicecount<=bobcount){
                    ans[i]="Alice";
                    alicecount++;
                }
                else
                {
                    ans[i]="Bob";
                    bobcount++;
                }
            }
            else if(aliceneeds){
                ans[i]="Alice";
                alicecount++;
            }
            else{
                ans[i]="Bob";
                bobcount++;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna