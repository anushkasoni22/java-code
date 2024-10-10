import java.util.HashMap;
import java.util.Map;

class Day1{
    public int maxDistance(int[] arr) {
        // Code here
        Map<Integer, Integer> hm = new HashMap<>();
        int maxcount = 0;
        for(int i=0; i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i], i);
            }
            else{
                maxcount = Math.max(maxcount, i-hm.get(arr[i]));
            }
        }
        return maxcount;
    }
    public static void main(String args[]){
        int arr[] = {1,1,2,2,2,1};
        Day1 d = new Day1();
        System.out.println(d.maxDistance(arr));
    }
}