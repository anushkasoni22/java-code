import java.util.Deque;
import java.util.LinkedList;

public class Day39 {
    //Shortest Subarray with Sum at Least K
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;
        
        Deque<Integer> deq = new LinkedList<>();
        long[] Sum = new long[N]; 
        
        int result = Integer.MAX_VALUE;
        int j = 0;
        while (j < N) {
            if (j == 0)
                Sum[j] = nums[j];
            else
                Sum[j] = Sum[j - 1] + nums[j];
    
            if (Sum[j] >= k) 
                result = Math.min(result, j + 1);
            
            while (!deq.isEmpty() && Sum[j] - Sum[deq.peekFirst()] >= k) {
                result = Math.min(result, j - deq.peekFirst());  
                deq.pollFirst();  
            }
            while (!deq.isEmpty() && Sum[j] <= Sum[deq.peekLast()]) {
                deq.pollLast();  
            }
            deq.offerLast(j);

            j++; 
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    //Reverse an Array
    public void reverseArray(int arr[]) {
        int start = 0, end = arr.length-1;
        while(start < end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Day39 d = new Day39();
        int[] nums = {2,-1,2};
        int k = 3;
        System.out.println(d.shortestSubarray(nums, k));

        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        d.reverseArray(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
