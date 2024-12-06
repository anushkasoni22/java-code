import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Day58{
    //Maximum Number of Integers to Choose From a Range I (leetcode)
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> Set = new HashSet<>();
        for (int i : banned) {
            Set.add(i);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (Set.contains(i)) {
                continue;
            }

            if (maxSum - i < 0) {
                return cnt;
            }

            maxSum -= i;
            cnt++;
        }
        return cnt;
    }

    //Find H-Index (gfg)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Day58 obj = new Day58();
        int banned[] = {1,6,5};
        int n = 5, maxSum = 6;
        System.out.println("Maximum Number of Integers to Choose From a Range I: " + obj.maxCount(banned, n, maxSum));

        int citations[] = {3, 0, 5, 3, 0};
        System.out.println("H-Index: " + obj.hIndex(citations));
    }
}