class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> idleServers = new TreeSet<>();
        for(int i=0;i<k;++i){
            idleServers.add(i);
        }
        PriorityQueue<int[]> busyHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] times=new int[k];
        for(int i=0;i<arrival.length;++i){
            int currArrival = arrival[i];
            while(!busyHeap.isEmpty()&&busyHeap.peek()[0]<=currArrival){
                idleServers.add(busyHeap.poll()[1]);
            }
            if(idleServers.isEmpty()){
                continue;
            }
            Integer server=idleServers.ceiling(i % k);
            if(server == null){
                server=idleServers.first(); 
            }
            idleServers.remove(server);
            times[server]++;
            busyHeap.offer(new int[]{currArrival + load[i], server});
        }
        int maxRequests=0;
        for(int count : times){
            maxRequests=Math.max(maxRequests,count);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<k;++i){
            if(times[i]==maxRequests){
                result.add(i);
            }
        }
        return result; 
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna