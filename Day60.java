import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Day60{
    //Two Best Non-Overlapping Events (leetcode)
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int prevMax = 0, ans = 0;
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
                prevMax = Math.max(prevMax, pq.poll()[1]);
            }

            ans = Math.max(ans, prevMax + event[2]);
            pq.offer(new int[]{event[1], event[2]});
        }
        return ans;
    }

    //Overlapping Intervals
    public List<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : arr) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        Day60 day60 = new Day60();
        int event[][] = {{1,3,2}, {4,5,2}, {2,4,3}};
        System.out.println(day60.maxTwoEvents(event));

        int arr[][] = {{1,3}, {2,4}, {6,8}, {9,10}};
        System.out.println(Arrays.deepToString(day60.mergeOverlap(arr).toArray()));
    }
}