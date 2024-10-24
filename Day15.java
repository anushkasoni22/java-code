import java.util.ArrayList;

public class Day15 {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        int n = arr.length;
        int nonZeroIndex = 0; 
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] = arr[i] * 2; 
                arr[i + 1] = 0;
            }
            if (arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }
        while (nonZeroIndex < n) {
            arr[nonZeroIndex++] = 0;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {2,2,0,4,0,8};
        ArrayList<Integer> result = modifyAndRearrangeArr(arr);
        System.out.println(result);
    }
}
