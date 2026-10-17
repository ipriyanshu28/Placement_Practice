public class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(digitSum(nums[i]), nums[i], i);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.sum != b.sum) return a.sum - b.sum;
            return a.value - b.value;
        });
        int[] indexMap = new int[n];
        for (int i = 0; i < n; i++) {
            indexMap[arr[i].originalIndex] = i;
        }
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap[i] == i) continue;
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap[j];
                cycleSize++;
            }
            swaps += cycleSize - 1;
        }
        return swaps;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    static class Pair {
        int sum, value, originalIndex;
        Pair(int sum, int value, int originalIndex) {
            this.sum = sum;
            this.value = value;
            this.originalIndex = originalIndex;
        }
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna