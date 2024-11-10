import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Day32 {
    //Shortest Subarray With OR at Least K II
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        
        List<Integer> arr = new ArrayList<>(Collections.nCopies(32, 0));

        while (j < n) {
            updateBit(nums[j], arr, 1);

            while (i <= j && getDecimalFromBinary(arr) >= k) {
                result = Math.min(result, j - i + 1);
                updateBit(nums[i], arr, -1);
                i++;
            }
            j++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void updateBit(int num, List<Integer> vec, int val) {
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                vec.set(i, vec.get(i) + val);
            }
        }
    }

    private int getDecimalFromBinary(List<Integer> vec) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if (vec.get(i) > 0) {
                num |= (1 << i);
            }
        }
        return num;
    }

    //Union of Two Sorted Arrays with Distinct Elements
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> unionList = new ArrayList<>();

        for (int num : a) {
            set.add(num);
        }
        for (int num : b) {
            set.add(num);
        }
        
        unionList.addAll(set);
        unionList.sort(null);  
        
        return unionList;
    } 

    public static void main(String[] args) {
        Day32 d = new Day32();
        int[] nums = { 1, 1, 4, 2, 3 };
        int k = 5;
        System.out.println(d.minimumSubarrayLength(nums, k));

        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 2, 4, 6, 8 };
        System.out.println(findUnion(a, b));
    }
}
