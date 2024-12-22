import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Day74{
    //Search in a Row-Column sorted matrix(gfg)
    public static boolean matSearch(int mat[][], int x) {
        int row = 0, col = mat[0].length-1;
        while(row < mat.length && col >= 0){
            if(mat[row][col] == x){
                return true;
            }
            else if(mat[row][col] > x){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

    //Find Building Where Alice and Bob Can Meet
    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int totalQueries = queries.length;

        int[] ans = new int[totalQueries];
        Arrays.fill(ans, -1);

        Map<Integer, List<int[]>> queryMap = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int q = 0; q < totalQueries; q++) {
            int i = queries[q][0];
            int j = queries[q][1];

            if (i < j && heights[i] < heights[j]) {
                ans[q] = j;
            } else if (i > j && heights[i] > heights[j]) {
                ans[q] = i;
            } else if (i == j) {
                ans[q] = i;
            } else {
                int maxIndex = Math.max(i, j);
                int maxHeight = Math.max(heights[i], heights[j]);
                queryMap.computeIfAbsent(maxIndex, k -> new ArrayList<>()).add(new int[]{maxHeight, q});
            }
        }

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                int queryIndex = pq.poll()[1];
                ans[queryIndex] = i;
            }

            if (queryMap.containsKey(i)) {
                for (int[] entry : queryMap.get(i)) {
                    pq.add(entry);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int mat[][] = {{3,30,38},{20,52,54},{35,60,69}};
        int x = 62;
        System.out.println(matSearch(mat, x));   
        
        int heights[] = {6,4,8,5,2,7};
        int queries[][] = {{0,1}, {0,3}, {2,4}, {3,4}, {2,2}};
        int ans[] = leftmostBuildingQueries(heights, queries);
        System.out.println(Arrays.toString(ans));
    }
}