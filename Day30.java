import java.util.*;
public class Day30 {
    //Maximum XOR for Each Query
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int result[] = new int[n];

        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        int mask = (1 << maximumBit) - 1;

        for(int i=0; i<n; i++){
            result[i] = xor^mask;
            xor ^= nums[n-i-1];
        }
        return result;
    }

    //Minimum repeat to make substring
    public int minRepeats(String s1, String s2) {
        for(int i =0;i<s2.length();i++){
            if(!s1.contains(String.valueOf(s2.charAt(i)))){
                return -1;
            }
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (sb.length() < s2.length()) {
            sb.append(s1);
            count++;
        }

        if (sb.toString().contains(s2)) {
            return count;
        }

        sb.append(s1);
        count++;

        if (sb.toString().contains(s2)) {
            return count;
        }

        return -1;
    }

    public static void main(String[] args) {
        Day30 solution = new Day30();
        String s1 = "abcd";
        String s2 = "cdabcdab";
        System.out.println(solution.minRepeats(s1, s2));

        int[] nums = {0,1,1,3};
        int[] result = solution.getMaximumXor(nums, 2);
        System.out.println(Arrays.toString(result));

    }
}
