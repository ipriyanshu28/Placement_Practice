class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String start = arriveAlice.compareTo(arriveBob)>0?arriveAlice:arriveBob;
        String end = leaveAlice.compareTo(leaveBob)<0?leaveAlice:leaveBob;
        int s=toDay(start);
        int e=toDay(end);
        return Math.max(0,e-s+1);
    }
    private int toDay(String date){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3));
        int total=day;
        for(int i=0;i<month-1;i++){
            total += days[i];
        }
        return total;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna