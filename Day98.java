import java.util.HashMap;
import java.util.Map;

public class Day98 {
    //Longest Subarray with Sum K
    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> prefixSumIndex = new HashMap<>(); 
        int sum = 0;                                           
        int maxLength = 0;                                     

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; 

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (prefixSumIndex.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumIndex.get(sum - k));
            }

            prefixSumIndex.putIfAbsent(sum, i);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Day98 obj = new Day98(); 
        int[] arr = {1, 2, 3, 4, 5}; 
        int k = 5; 
        System.out.println(obj.longestSubarray(arr, k));
    }    
}
