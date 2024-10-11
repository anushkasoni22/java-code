import java.util.*;
public class Day2 {
    int missingNumber(int n, int arr[]) {
        Arrays.sort(arr);

        // Your Code Here
        int missingNum = 0;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] - arr[i-1] > 1){
                missingNum = arr[i-1] + 1;
                break; // No need to continue searching
            }
        }
        
        if(missingNum==0){
            if(arr[0]!=1){
                return 1;
            } else {
                return n;
            }
        }
        
        return missingNum;
    }

    public static void main(String args[]) {
        Day2 d = new Day2();
        int arr[] = {1, 2, 3, 4, 5, 7, 8, 9};
        System.out.println(d.missingNumber(9, arr));
    }
}

