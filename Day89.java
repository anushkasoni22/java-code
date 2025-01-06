import java.util.*;
class Day89{
    //Minimum Number of Operations to Move All Balls to Each Box (leetcode)
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        int value = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            value += boxes.charAt(i) == '0' ? 0 : 1;
            sum += value;
        }

        value = 0;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += sum;
            value += boxes.charAt(i) == '0' ? 0 : 1;
            sum += value;
        }
        return ans;
    }

    //Sum Pair closest to target (gfg)
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = arr.length-1;
        int diff = Integer.MAX_VALUE;
        
        while(l < r){
            int sum = arr[l] + arr[r];
            if(Math.abs(target - sum) < diff){
                diff = Math.abs(target - sum);
                ans.clear();
                ans.add(arr[l]);
                ans.add(arr[r]);
            }
            if(sum < target){
                l++;
            }
            else{
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Day89 obj = new Day89();
        String boxes = "110";
        int ans[] = obj.minOperations(boxes);
        System.out.println(Arrays.toString(ans));

        int arr[] = {10,30,20,5}, target = 25;
        System.out.println(obj.sumClosest(arr, target));
    }
}