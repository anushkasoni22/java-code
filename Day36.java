import java.util.Arrays;
import java.util.PriorityQueue;

public class Day36 {
    //Minimized Maximum of Products Distributed to Any Store
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = Arrays.stream(quantities).max().getAsInt();
        int result = 0;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (possibleToDistr(mid, quantities, n)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }  
        return result;
    }
    
    private boolean possibleToDistr(int x, int[] quantities, int shops) {
        for (int products : quantities) {
            shops -= (products + x - 1) / x;
            if (shops < 0) {
                return false;
            }
        }
        return true;
    }

    //Nearly sorted
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j=0, n=arr.length;
        for(int i=0; i<n; i++){
            pq.offer(arr[i]);
            if(i>=k){
                arr[j++] = pq.poll();
            }    
        }    
        while(!pq.isEmpty()){
            arr[j++] = pq.poll();
        }
    }

    public static void main(String[] args) {
        Day36 day36 = new Day36();
        System.out.println(day36.minimizedMaximum(7, new int[]{15, 10, 10}));

        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        day36.nearlySorted(arr, 3);
    }
}
