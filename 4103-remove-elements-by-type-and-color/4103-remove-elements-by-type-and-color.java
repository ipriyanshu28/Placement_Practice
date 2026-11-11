class Solution {
    static class Node{
        int type,color,count;
        Node(int type,int color,int count){
            this.type=type;this.color=color;
            this.count=count;
        }
    }
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        Deque<Node> stack=new ArrayDeque<>();
        for(int i=0;i<types.length;i++){
            int t=types[i];
            int c=colors[i];
            if(!stack.isEmpty()&&stack.peek().type==t&&stack.peek().color==c){
                stack.peek().count++;
            }
            else{
                stack.push(new Node(t,c,1));
            }
            if(stack.peek().count==groupSize[t]){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna