import java.util.*;
class Day78{
    //Target Sum(leetcode)
    private int S;

    private int solve(int[] nums, int target, int i, int sum, int[][] t) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (t[i][sum + S] != Integer.MIN_VALUE) {
            return t[i][sum + S];
        }

        int plus = solve(nums, target, i + 1, sum + nums[i], t);
        int minus = solve(nums, target, i + 1, sum - nums[i], t);

        return t[i][sum + S] = plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        S = Arrays.stream(nums).sum();
        int[][] t = new int[n][2 * S + 1];

        for (int[] row : t) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return solve(nums, target, 0, 0, t);
    }

    //Two Sum - Pair with Given Sum(gfg)
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> ans = new HashSet<>();
        for (int i : arr) {
            int ele = target - i;
            if (ans.contains(ele)) {
                return true; 
            }
            ans.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        Day78 d = new Day78();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(d.findTargetSumWays(nums, target));

        int arr[] = {1,4,45,6,10,8}, target1 = 16;
        System.out.println(d.twoSum(arr, target1));
    }
}