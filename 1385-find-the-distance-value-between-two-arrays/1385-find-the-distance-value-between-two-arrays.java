class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int dist = 0;
        for (int val : arr1) {
            if (!hasElementInRange(arr2, val - d, val + d)) {
                dist++;
            }
        }
        return dist;
    }
    private boolean hasElementInRange(int[] arr, int from, int to) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid=left+(right - left)/2;
            if (arr[mid] >= from && arr[mid] <= to){
                return true; 
            } 
            else if (arr[mid] < from){
                left = mid + 1;
            } 
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna