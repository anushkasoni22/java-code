import java.util.Arrays;
class Day57{
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }

            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            if (i == n || j == n) {
                return i == n && j == n;
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
           
            if (start.charAt(i) == 'L' && i < j) {
                return false;  
            }

            if (start.charAt(i) == 'R' && i > j) {
                return false;  
            }
            i++;
            j++;
        }
        return true;
    }

    //Sort 0s, 1s and 2s
    public void sort012(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        Day57 obj = new Day57();
        String start = "_L__R__R_", target = "L______RR";
        System.out.println(obj.canChange(start, target));

        int arr[] = {0,1,2,0,1,2};
        obj.sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
}