import java.util.*;
public class Day16 {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;           
        int j = arr.length - 1; 
        
        while (i <= j) {
            if (j >= i) {
                result.add(arr[j--]);
            }
            if (i <= j) {
                result.add(arr[i++]); 
            }
        }    
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 1, 2, 3, 4, 5, 6};
        System.out.println(alternateSort(arr1)); 

        int[] arr2 = {1, 6, 9, 4, 3, 7, 8, 2};
        System.out.println(alternateSort(arr2)); 
    }
}
