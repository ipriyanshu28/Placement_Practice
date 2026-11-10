class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> result = new ArrayList<>();
        int n=s1.length(),i=0;
        while(i<n){
            if(s1.charAt(i)!=s2.charAt(i)){
                int start=i;
                while(i<n&&s1.charAt(i)!=s2.charAt(i)){
                    i++;
                }
                List<String> segment=new ArrayList<>();
                segment.add(s1.substring(start,i));
                segment.add(s2.substring(start,i));
                result.add(segment);
            } 
            else{
                i++;
            }
        } 
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna