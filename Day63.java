import java.util.Arrays;

class Day63{
    //Merge Without Extra Space (gfg)
    public void mergeArrays(int a[], int b[]) {
        int n = a.length, m = b.length;
        int i = n - 1, j = 0;

        while (i >= 0 && j < m) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    //Maximum Beauty of an Array After Applying Operation (leetcode)
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = 0;
        int maxBeauty = 0;

        while (i < n) {
            while (j < n && nums[j] - nums[i] <= 2 * k) {
                j++;
            }
            maxBeauty = Math.max(maxBeauty, j - i);
            i++;
        }
        return maxBeauty;
    }

    public static void main(String[] args) {
        Day63 d = new Day63();
        int a[] = {2,4,7,10};
        int b[] = {2,3};
        d.mergeArrays(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        int nums[] = {4,6,1,2};
        int k = 2;
        System.out.println(d.maximumBeauty(nums, k));
    }
}