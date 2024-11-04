import java.util.ArrayList;
import java.util.List;

public class Day26 {
    //Find All Triplets with Zero Sum
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        //Arrays.sort(arr);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i]+arr[j]+arr[k] == 0){
                        result.add(List.of(i,j,k));
                    }
                }
            }
        }
        return result;
    }

    //String Compression III
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder("");

        int i = 0;
        while (i < word.length()) {
            int Count = 0;

            char currChar = word.charAt(i);
            while (i < word.length() && Count < 9 && word.charAt(i) == currChar) {
                Count++;
                i++;
            }
            sb.append(Count).append(currChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Day26 d = new Day26();
        int[] arr = {0, -1, 2, -3, 1};
        List<List<Integer>> result = d.findTriplets(arr);
        System.out.println(result);

        String word = "aabbcc";
        String compressed = d.compressedString(word);
        System.out.println(compressed);
    }
}
