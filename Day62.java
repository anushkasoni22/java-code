import java.util.*;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

class Day62 {
    // Find Longest Special Substring That Occurs Thrice I (leetcode)
    public int maximumLength(String s) {
        int n = s.length();
        Map<Pair<Character, Integer>, Integer> count = new HashMap<>();
        int l = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            l = 0;

            for (int j = i; j < n; j++) {
                if (ch == s.charAt(j)) {
                    l++;
                    Pair<Character, Integer> key = new Pair<>(ch, l);
                    count.put(key, count.getOrDefault(key, 0) + 1);
                } else {
                    break;
                }
            }
        }

        int ans = 0;
        for (Map.Entry<Pair<Character, Integer>, Integer> entry : count.entrySet()) {
            int length = entry.getKey().getValue(); 
            if (entry.getValue() >= 3 && length > ans) {
                ans = length;
            }
        }
        return ans == 0 ? -1 : ans;
    }

    //Non-overlapping Intervals
    public int minRemoval(int intervals[][]) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; 
        int prevEnd = Integer.MIN_VALUE; 

        for (int[] interval : intervals) {
            if (interval[0] < prevEnd) {
                count++;
            } else {
                prevEnd = interval[1];
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Day62 d = new Day62();
        String s = "aaaa";
        System.out.println(d.maximumLength(s));

        int intervals[][] = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(d.minRemoval(intervals));
    }
}