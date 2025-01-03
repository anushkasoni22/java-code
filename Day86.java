import java.util.HashMap;

public class Day86 {
    //Number of Ways to Split Array (leetcode)
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long leftSum = 0;
        long rightSum = 0;
        int split = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;

            if (leftSum >= rightSum) {
                split++;
            }
        }
        return split;
    }

    //Count Subarrays with given XOR (gfg)
    public long subarrayXor(int arr[], int k) {
        int xor = 0, ans = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        for(int i : arr){
            xor ^= i;
            
            if(xor == k)ans++;
            ans+=mp.getOrDefault(xor^k,0);
            mp.put(xor, mp.getOrDefault(xor,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Day86 d = new Day86();
        int nums[] = {10,4,-8,7};
        System.out.println(d.waysToSplitArray(nums));

        int arr[] = {4,2,2,6,4}, k=6;
        System.out.println(d.subarrayXor(arr, k));
    }
}
