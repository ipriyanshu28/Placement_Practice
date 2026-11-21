class Solution {
    private List<Integer>[] origChildren;
    private List<Integer>[] newChildren;
    private int[] ans;
    private int[] lastSeen;
    private String s;
    @SuppressWarnings("unchecked")
    public int[] findSubtreeSizes(int[] parent, String s){
        int n = parent.length;
        this.s = s;
        this.origChildren = new ArrayList[n];
        this.newChildren = new ArrayList[n];
        this.ans = new int[n];
        this.lastSeen = new int[26];
        for(int i=0;i<n;i++){
            origChildren[i] = new ArrayList<>();
            newChildren[i] = new ArrayList<>();
        }
        Arrays.fill(lastSeen,-1);
        for(int i=1;i<n;i++){
            origChildren[parent[i]].add(i);
        }
        reassignDfs(0,parent);
        computeSizeDfs(0);
        return ans;
    }
    private void reassignDfs(int u, int[] parent){
        int charIdx=s.charAt(u) - 'a';
        int prevAncestor=lastSeen[charIdx];
        if(u != 0){
            int targetParent=(prevAncestor != -1) ? prevAncestor : parent[u];
            newChildren[targetParent].add(u);
        }
        lastSeen[charIdx]=u;
        for(int v : origChildren[u]){
            reassignDfs(v, parent);
        }
        lastSeen[charIdx]=prevAncestor;
    }
    private int computeSizeDfs(int u){
        int size = 1;
        for(int v : newChildren[u]){
            size += computeSizeDfs(v);
        }
        ans[u]=size;
        return size;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna