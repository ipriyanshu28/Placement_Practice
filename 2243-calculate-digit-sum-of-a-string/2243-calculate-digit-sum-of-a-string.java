class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder nextr= new StringBuilder();
            for(int i=0;i<s.length();i += k){
                int end=Math.min(i+k,s.length());
                String g=s.substring(i,end);
                int sum=0;
                for(int j=0;j<g.length();j++){
                    sum += g.charAt(j)-'0';
                }
                nextr.append(sum);
            }
            s = nextr.toString();
        } 
        return s;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna