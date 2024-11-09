public class Day31 {
    public long minEnd(int n, int x) {
        long ans = x;
        for (int i = 1; i < n; i++) {
            ans = (ans + 1) | x;
        }

        return ans;
    }
    public static void main(String[] args) {
        Day31 d = new Day31();
        int n = 3, x = 4;
        System.out.println(d.minEnd(n, x));
    }
}
