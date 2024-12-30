import java.util.Arrays;
import java.util.HashSet;

class Day82{
    //Count Ways To Build Good Strings (leetcode)
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);
        return count(low, high, zero, one, 0, dp)%mod;
    }

    private int count(int low, int high, int zero, int one, int len, int[] dp) {
        if(len>high) return 0;
        if(dp[len]!=-1) return dp[len];
        int ans = (count(low, high, zero, one, len+zero, dp)%mod
                  + count(low, high, zero, one, len+one, dp)%mod)%mod;
        if(len>=low && len<=high) ans+=1;
        return dp[len]=ans%mod;
    }

    //Union of Arrays with Duplicates (gfg)
    public static int findUnion(int a[], int b[]) {
        HashSet<Integer> ans = new HashSet<>();
        for (int num : a) {
            ans.add(num);
        }

        for (int num : b) {
            ans.add(num);
        }
        return ans.size();
    }

    public static void main(String[] args) {
        Day82 d = new Day82();
        System.out.println(d.countGoodStrings(3, 3, 1, 1));

        int a[] = {1,2,3,4,5}, b[] = {1,2,3};
        System.out.println(findUnion(a, b));
    }
}