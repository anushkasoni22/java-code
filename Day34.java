import java.util.Arrays;

public class Day34 {
    //Most Beautiful Item for Each Query(leetcode)
    public static int[] maximumBeauty(int[][] items, int[] queries) {
            Arrays.sort(items, (a,b) -> a[0]-b[0]);
    
            for (int i = 1; i < items.length; i++) {
                items[i][1] = Math.max(items[i][1], items[i - 1][1]);
            }
    
            for (int i = 0; i < queries.length; i++) {
                int queryPrice = queries[i];
                int low = 0, high = items.length - 1;
                int maxBeauty = 0;
    
                // Binary search for the highest price <= queryPrice
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (items[mid][0] <= queryPrice) {
                        maxBeauty = items[mid][1];
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                // Update queries[i] with the maximum beauty found
                queries[i] = maxBeauty;
            }
            return queries;
        }
    
        //Meeting Rooms
        static boolean canAttend(int[][] arr) {
            // Your code here
            Arrays.sort(arr,(a,b) -> Integer.compare(a[0], b[0]));
            
            for(int i=1; i<arr.length; i++){
                if(arr[i][0] < arr[i-1][1]){
                    return false;
                }
            }
            return true;
        }
    
        public static void main(String[] args) {
            int[][] items = {{1,2}, {3,2}, {2,4}, {5,6}, {3,5}};
            int[] queries = {1, 2, 3, 4, 5, 6};
            System.out.println(Arrays.toString(maximumBeauty(items, queries)));

        int arr[][] = {{1,4}, {10,15}, {7,10}};
        System.out.println(canAttend(arr));
    }
}
