import java.util.Arrays;

class Day65{
    //Find Score of an Array After Marking All Elements (leetcode)
    public long findScore(int[] nums) {
        int n = nums.length;
        long score = 0;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            int value = pairs[i][0];
            int index = pairs[i][1];

            if (!marked[index]) {
                score += value;
                marked[index] = true;

                if (index - 1 >= 0) {
                    marked[index - 1] = true;
                }
                if (index + 1 < n) {
                    marked[index + 1] = true;
                }
            }
        }
        return score;
    }

    //Sorted and Rotated Minimum (gfg)
    public static int findMin(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }

    public static void main(String[] args) {
        Day65 obj = new Day65();
        int nums[] = {2,1,3,4,5,2};
        System.out.println(obj.findScore(nums));

        int arr[] = {5,6,1,2,3,4};
        System.out.println(findMin(arr));
    }
}