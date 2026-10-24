class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000"))
            return -1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++){
                String curr = q.poll();
                if (curr.equals(target))
                    return steps;
                for (String next : getNeighbors(curr)){
                    if (!dead.contains(next) && visited.add(next)){
                        q.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private List<String> getNeighbors(String s){
        List<String> neighbors = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++){
            char original = arr[i];
            arr[i] = original == '9' ? '0' : (char) (original + 1);
            neighbors.add(new String(arr));
            arr[i] = original == '0' ? '9' : (char) (original - 1);
            neighbors.add(new String(arr));
            arr[i] = original;
        }
        return neighbors;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna