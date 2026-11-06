class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int m = queries.length;
        int[][] qs = new int[m][2];
        for(int i = 0; i < m; i++){
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        Arrays.sort(qs, (a, b) -> Integer.compare(a[0], b[0]));
        int[] ans = new int[m];
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, right = 0;
        int active = 0;
        for(int[] q : qs){
            int time = q[0];
            while(right < logs.length && logs[right][1] <= time){
                int server = logs[right][0];
                int count = freq.getOrDefault(server,0);
                if (count == 0) {
                    active++;
                }
                freq.put(server, count + 1);
                right++;
            }
            while(left < right && logs[left][1] < time - x){
                int server = logs[left][0];
                int count = freq.get(server);
                if (count == 1){
                    freq.remove(server);
                    active--;
                } 
                else{
                    freq.put(server, count - 1);
                }
                left++;
            }
            ans[q[1]] = n - active;
        }
        return ans;
    }
}
        
    

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna