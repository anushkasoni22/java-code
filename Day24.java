import java.util.HashSet;
class Day24{
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);

            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Day24 d = new Day24();
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        System.out.println(d.checkDuplicatesWithinK(arr, k));
    }
}