import java.util.HashSet;

class Day83{
    //Longest Consecutive Subsequence (gfg)
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> nums = new HashSet<>();
        for (int num : arr) {
            nums.add(num);
        }

        int maxLen = 0;

        for (int num : arr) {
            if (!nums.contains(num - 1)) {
                int curr = num;
                int len = 1;

                while (nums.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Day83 d = new Day83();
        int[] arr = {2,6,1,9,4,5,3};
        System.out.println(d.longestConsecutive(arr));
    }
}