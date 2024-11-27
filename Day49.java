import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Day49{
    //Smallest Positive Missing Number(gfg)
    public int missingNumber(int[] arr) {
        Arrays.sort(arr);
        int missing = 1; 
        for (int num : arr) {
            if (num == missing) {
                missing++; 
            } else if (num > missing) {
                break;
            }
        }
        return missing;
    }

    //Shortest Distance After Road Addition Queries I(leetcode)
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();

                if (node == n - 1) {
                    return level; 
                }
                for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            level++;
        }
        return -1; 
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj.clear();
        for (int i = 0; i < n - 1; i++) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }
        int k = queries.length;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj.computeIfAbsent(u, k1 -> new ArrayList<>()).add(v);
            res[i] = bfs(n);
        }
        return res;
    }

    public static void main(String[] args) {
        Day49 Day = new Day49();
        int arr[] = {2, -3, 4, 1, 1, 7};
        System.out.println(Day.missingNumber(arr));

        int n = 5;
        int[][] queries = {{2,4}, {0,2}, {0,4}};
        System.out.println(Arrays.toString(Day.shortestDistanceAfterQueries(n, queries)));
    }
}