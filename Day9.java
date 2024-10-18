//Given an array arr[] of positive integers where every element appears even times except for one. Find that number occurring an odd number of times.
public class Day9 {

    public static int getOddOccurrence(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 3, 9, 3, 9, 7, 9 };
        System.out.println(getOddOccurrence(arr));
    }
}
