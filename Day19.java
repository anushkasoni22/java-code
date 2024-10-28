import java.util.*;
public class Day19 {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
        HashSet<Integer> uniqueElements = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (!uniqueElements.contains(num)) {
                uniqueElements.add(num);
                result.add(num);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Day19 d = new Day19();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> result = d.removeDuplicate(arr);
        System.out.println(result);
    }
}
