import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day29 {
    public List<Integer> findSplit(int[] arr) {
        int totalsum = 0;
        for(int num : arr){
            totalsum += num;
        }
        
        List<Integer> result = new ArrayList<>(Arrays.asList(-1, -1));
        if(totalsum % 3 != 0){
            return result;
        }
        int targetsum = totalsum/3;
        int currsum = 0;
        int firstidx = -1;
        int secidx = -1;
        for(int i=0; i<arr.length; i++){
            currsum += arr[i];
            if(currsum == targetsum && firstidx == -1){
                firstidx = i;
            }
            else if(currsum == 2*targetsum && firstidx != -1){
                secidx = i;
                result.set(0, firstidx);
                result.set(1, secidx);
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Day29 d = new Day29();
        int[] arr = {1, 3, 4, 0, 4};
        List<Integer> result = d.findSplit(arr);
        System.out.println(result);
    }
}
