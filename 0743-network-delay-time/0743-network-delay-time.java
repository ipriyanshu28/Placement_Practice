class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj=new HashMap<>();
        for(int[] time:times){
            adj.computeIfAbsent(time[0],x->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }
        for(List<int[]> neighbors : adj.values()){
            neighbors.sort((a, b) -> a[1]-b[1]);
        }
        int[] minTime=new int[n+1];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        dfs(k, 0, adj, minTime);
        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            if(minTime[i] == Integer.MAX_VALUE) return -1; 
            maxTime = Math.max(maxTime, minTime[i]);
        }
        return maxTime;
    }
    private void dfs(int u, int elapsedTime, Map<Integer, List<int[]>> adj, int[] minTime){
        if (elapsedTime >= minTime[u]){
            return;
        }
        minTime[u]=elapsedTime;
        if(adj.containsKey(u)){
            for(int[] edge : adj.get(u)){
                int v = edge[0];
                int weight = edge[1];
                dfs(v, elapsedTime + weight, adj, minTime);
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna